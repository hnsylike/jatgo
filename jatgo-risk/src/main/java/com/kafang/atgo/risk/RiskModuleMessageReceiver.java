package com.kafang.atgo.risk;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;

import io.ffreedom.common.charset.Charsets;
import io.ffreedom.common.log.UseLogger;
import io.ffreedom.common.utils.StringUtil;
import io.ffreedom.transport.rabbitmq.RabbitMqReceiver;
import io.ffreedom.transport.rabbitmq.config.RmqReceiverConfigurator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RiskModuleMessageReceiver {

	@Value("${mq.host}")
	private String host;
	@Value("${mq.port}")
	private int port;
	@Value("${mq.username}")
	private String mqUsername;
	@Value("${mq.password}")
	private String mqPassword;
	@Value("${mq.auto.ack}")
	private boolean isMqAutoAck;
	@Value("${mq.auto.recovery}")
	private boolean isMqAutoRecovery;
	@Value("${mq.queue.biz.risk}")
	private String receiveBizQueue;

	private RiskModuleMessageHandler messageHandler;

	public RiskModuleMessageReceiver(RiskModuleMessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	@PostConstruct
	private void init() {

		log.info("RiskModuleReceiver start initialization...");

		new RabbitMqReceiver("RiskModuleReceiver",
				RmqReceiverConfigurator.configuration().setConnectionParam(host, port)
						.setUserParam(mqUsername, mqPassword).setAutoAck(isMqAutoAck).setAutoDelete(false)
						.setAutomaticRecovery(isMqAutoRecovery).setShutdownEvent(ex -> UseLogger.error(log, ex))
						.setReceiveQueue(receiveBizQueue),
				bytes -> {
					try {
						String msgString = new String(bytes, Charsets.UTF8);
						log.info("RiskModule received message :[{}] at {}", msgString, LocalDateTime.now());
						if (StringUtil.isNullOrEmpty(msgString)) {
							messageHandler.onMessage(msgString);
						}
					} catch (FixMessageAnalysisException e) {
						UseLogger.error(log, e);
					}
				}).receive();

		log.info("RiskModuleReceiver initialized...");
		// TODO 補充發布者信息
		// Publisher<byte[]> publisher = new RabbitMqPublisher("MemoryReceiver",
		// RmqPublisherConfigurator.configuration());

	}

}
