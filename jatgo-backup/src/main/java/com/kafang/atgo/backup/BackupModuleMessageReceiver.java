package com.kafang.atgo.backup;

import io.ffreedom.common.charset.Charsets;
import io.ffreedom.common.log.UseLogger;
import io.ffreedom.common.utils.StringUtil;
import io.ffreedom.transport.rabbitmq.RabbitMqReceiver;
import io.ffreedom.transport.rabbitmq.config.RmqReceiverConfigurator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Slf4j
@Component
public class BackupModuleMessageReceiver {

	@Autowired
	private BackupMqProperties properties;

	private BackupModuleMessageHandler messageHandler;

	@Autowired
	public BackupModuleMessageReceiver(BackupModuleMessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	@PostConstruct
	public void init() {
		new RabbitMqReceiver("BackupReceiver",
				RmqReceiverConfigurator.configuration()
						.setConnectionParam(properties.getHost(), properties.getPort())
						.setUserParam(properties.getMqUsername(), properties.getMqPassword())
						.setShutdownEvent(ex -> UseLogger.error(log, ex))
						.setReceiveQueue(properties.getReceiveBizQueue()).setAutoAck(properties.isMqAutoAck())
						.setAutomaticRecovery(properties.isMqAutoRecovery()),
				bytes -> {
					String msgString = new String(bytes, Charsets.UTF8);
					log.info("BackupModule received message :[{}] at {}", msgString, LocalDateTime.now());
					if (!StringUtil.isNullOrEmpty(msgString)) {
						messageHandler.onMessage(msgString);
					}
				}).receive();
		log.info("BackupModuleMessageReceiver started...");
	}
}
