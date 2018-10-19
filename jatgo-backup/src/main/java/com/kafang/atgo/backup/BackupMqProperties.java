package com.kafang.atgo.backup;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@Getter
@Order(LoadOrder.FIRST)
public final class BackupMqProperties {

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

    @Value("${mq.queue.biz.backup}")
    private String receiveBizQueue;

    @PostConstruct
    public void output() {
        log.info("RabbitMq host -> {}", host);
        log.info("RabbitMq port -> {}", port);
        log.info("RabbitMq username -> {}", mqUsername);
        log.info("RabbitMq password -> {}", mqPassword);
        log.info("RabbitMq isAutoAck -> {}", isMqAutoAck);
        log.info("RabbitMq isAutoRecovery -> {}", isMqAutoRecovery);
    }

}
