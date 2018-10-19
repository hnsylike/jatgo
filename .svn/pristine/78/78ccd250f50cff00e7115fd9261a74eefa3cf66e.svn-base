package com.kafang.atgo.backup.init;

import com.kafang.atgo.backup.BackupMqProperties;
import com.kafang.atgo.backup.LoadOrder;
import com.kafang.atgo.backup.resend.ResendConfigComponent;
import com.kafang.atgo.persistence.json.JsonSerializationUtil;
import io.ffreedom.common.functional.Initializer;
import io.ffreedom.common.log.UseLogger;
import io.ffreedom.transport.rabbitmq.RabbitMqOperatingTools;
import io.ffreedom.transport.rabbitmq.RabbitMqOperatingTools.OperationalChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Slf4j
@Component
@Order(LoadOrder.SECOND)
public class RabbitMqInitializer implements Initializer<Boolean> {

	@Autowired
	private BackupMqProperties properties;

	@Value("${backup.config.file.queue}")
	private String configFileName;

	@PostConstruct
	public void init() {
		if (initialize()) {
			log.info("RabbitMq Exchange & Queue successfully initialized...");
		} else {
			log.error("RabbitMq Exchange & Queue initialization failed!");
			System.exit(-1);
		}
	}

	@Override
	public Boolean initialize() {
		InputStream inputStream = ResendConfigComponent.class.getClassLoader().getResourceAsStream(configFileName);

		List<QueueConfig> queueConfigList = null;
		try {
			queueConfigList = JsonSerializationUtil.jsonToList(JsonSerializationUtil.InputStreamToJson(inputStream),
					QueueConfig.class);
		} catch (IOException e) {
			UseLogger.error(log, e);
		}
		if (queueConfigList == null) {
			return false;
		}
		try {
			OperationalChannel operationalChannel = RabbitMqOperatingTools.createChannel(properties.getHost(),
					properties.getPort(), properties.getMqUsername(), properties.getMqPassword());

			// Declare queue, if throw exception, return false.
			if (queueConfigList.stream().flatMap(queueConfig -> queueConfig.getBindQueues().stream()).distinct()
					.mapToInt(queueName -> {
						try {
							log.info("Declare queue -> {}", queueName);
							return operationalChannel.declareQueueUseDefaultParameter(queueName) ? 0 : 1;
						} catch (IOException e) {
							UseLogger.error(log, e);
							return 1;
						}
					}).sum() != 0)
				return false;
			// Declare exchange, if throw exception, return false.
			if (queueConfigList.stream().mapToInt(queueConfig -> {
				try {
					log.info("Declare Fanout Exchange -> {}", queueConfig.getExchange());
					return operationalChannel.declareFanoutExchange(queueConfig.getExchange()) ? 0 : 1;
				} catch (IOException e) {
					UseLogger.error(log, e);
					return 1;
				}
			}).sum() != 0)
				return false;
			// Bind queue to exchange, if throw exception, return false.
			if (queueConfigList.stream().mapToInt(queueConfig -> {
				try {
					for (String queue : queueConfig.getBindQueues()) {
						log.info("BindQueue : queue -> {}, bind to exchange -> {}.", queue, queueConfig.getExchange());
						if (!operationalChannel.bindQueue(queue, queueConfig.getExchange()))
							return 1;
					}
					return 0;
				} catch (IOException e) {
					UseLogger.error(log, e);
					return 1;
				}
			}).sum() != 0)
				return false;
		} catch (IOException | TimeoutException e) {
			UseLogger.error(log, e);
			return false;
		}
		return true;
	}

}
