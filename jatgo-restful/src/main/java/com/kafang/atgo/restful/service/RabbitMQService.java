package com.kafang.atgo.restful.service;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kafang.atgo.bean.fix.FixCancelOrder;
import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.bean.fix.base.FixBeanLegalityException;
import com.kafang.atgo.bean.fix.base.FixMessage;

import io.ffreedom.common.charset.Charsets;
import io.ffreedom.transport.base.role.Publisher;
import io.ffreedom.transport.base.role.Receiver;
import io.ffreedom.transport.rabbitmq.RabbitMqOperatingTools;
import io.ffreedom.transport.rabbitmq.RabbitMqPublisher;
import io.ffreedom.transport.rabbitmq.RabbitMqReceiver;
import io.ffreedom.transport.rabbitmq.config.RmqPublisherConfigurator;
import io.ffreedom.transport.rabbitmq.config.RmqReceiverConfigurator;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by User on 2018/9/17.
 */
@Service
@Slf4j
public class RabbitMQService {

    @Value("${mq.host}")
    private String host;
    @Value("${mq.port}")
    private int port;
    @Value("${mq.username}")
    private String mqUsername;
    @Value("${mq.password}")
    private String mqPassword;

    @Value("${mq.exchange.report.actual}")
    private String subExchange;
    @Value("${mq.exchange.report.actual.bindQueues}")
    private String subBindQueues;
    @Value("${mq.exchange.order.actual}")
    private String pubExchange;
    @Value("${mq.exchange.order.actual.bindQueues}")
    private String pubBindQueues;

    @Value("${mq.queue.biz.webserver}")
    private String subBizQueue;

    /**
     * Map {ClientId -> Map{ClOrdId -> List{FixOrder}}}.
     */
    private ConcurrentMap<Integer, ConcurrentMap<Long, MutableList<FixOrder>>> actualOrderCache = new ConcurrentHashMap<>(
            256);

    private Publisher<byte[]> orderPublisher;

    @Autowired
    private WebSocketService webSocketService;

    @PostConstruct
    public void init() {
        try {
            RabbitMqOperatingTools.OperationalChannel channel = RabbitMqOperatingTools.createChannel(host, port,
                    mqUsername, mqPassword);
            channel.declareFanoutExchange(subExchange);
            log.info("###declareFanoutExchange -> " + subExchange);
            String[] subBindQueuesArr = subBindQueues.intern().split(",");
            for (String subBindQueue : subBindQueuesArr) {
                channel.declareQueueUseDefaultParameter(subBindQueue);
                log.info("###declareQueueUseDefaultParameter -> " + subBindQueue);
                channel.bindQueue(subBindQueue, subExchange);
                log.info("###bindQueue -> " + subBindQueue + " to Exchange: " + subExchange);
            }
            channel.declareFanoutExchange(pubExchange);
            log.info("###declareFanoutExchange -> " + pubExchange);
            String[] pubBindQueuesArr = pubBindQueues.intern().split(",");
            for (String pubBindQueue : pubBindQueuesArr) {
                channel.declareQueueUseDefaultParameter(pubBindQueue);
                log.info("###declareQueueUseDefaultParameter -> " + pubBindQueue);
                channel.bindQueue(pubBindQueue, pubExchange);
                log.info("###bindQueue -> " + pubBindQueue + " to Exchange: " + pubExchange);
            }
            channel.close();
            log.info("###channel.close");
        } catch (IOException | TimeoutException e) {
            log.error("init rabbitMq {} error: {}", subBizQueue, e);
        }

        Receiver receiver = new RabbitMqReceiver("restful-receiver", RmqReceiverConfigurator.configuration()
                .setConnectionParam(host, port).setUserParam(mqUsername, mqPassword).setReceiveQueue(subBizQueue),
                (byte[] bytes) -> {
                    String msg = new String(bytes, Charsets.UTF8);
                    log.info("msg received from rmq: {}", msg);
                    try {
                        FixMessage fixMessage = new FixMessage(msg);
                        switch (fixMessage.getMsgType()) {
                            case OrderReport:
                            case Order:
                                FixOrder orderReport = new FixOrder(fixMessage);
                                if (!actualOrderCache.containsKey(orderReport.getClientId())) {
                                    actualOrderCache.put(orderReport.getClientId(), new ConcurrentHashMap<>());
                                }
                                ConcurrentMap<Long, MutableList<FixOrder>> clientOrderReportMap = actualOrderCache
                                        .get(orderReport.getClientId());
                                if (!clientOrderReportMap.containsKey(orderReport.getClOrdId())) {
                                    clientOrderReportMap.put(orderReport.getClOrdId(), FastList.newList());
                                }
                                clientOrderReportMap.get(orderReport.getClOrdId()).add(orderReport);
                                webSocketService.sendMessageByClientId(orderReport.getClientId(), orderReport);
                                break;
                            default:
                                log.info("recv message type is not order , MsgType == {}", fixMessage.getMsgType());
                        }
                    } catch (Exception e) {
                        log.error("accept rabbitMq {} error: {}", subBizQueue, e);
                    }
                });
        orderPublisher = new RabbitMqPublisher("restful-publisher", RmqPublisherConfigurator.configuration()
                .setConnectionParam(host, port).setUserParam(mqUsername, mqPassword).setModeFanout(pubExchange));
        receiver.receive();
        log.info(receiver.getName() + " started...");
    }

    public void sendNewOrder(FixOrder order) {
        try {
            sendOrder(order.toFixMessage().getBytes(Charsets.UTF8));
        } catch (FixBeanLegalityException e) {
            log.error("sendNewOrder order:{}。 error:{}", order, e);
        }
    }

    public void sendCancelOrder(FixCancelOrder order) {
        try {
            sendOrder(order.toFixMessage().getBytes(Charsets.UTF8));
        } catch (FixBeanLegalityException e) {
            log.error("sendCancelOrder order:{}。 error:{}", order, e);
        }
    }

    public Optional<ConcurrentMap<Long, MutableList<FixOrder>>> getOrderReportMap(int clientId) {
        return Optional.ofNullable(actualOrderCache.get(clientId));
    }

    private void sendOrder(byte[] byteMsg) {
        orderPublisher.publish(byteMsg);
    }

}
