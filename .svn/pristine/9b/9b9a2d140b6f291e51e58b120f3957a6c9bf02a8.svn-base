package com.kafang.atgo.backup.resend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.json.JsonSerializationUtil;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ResendConfigComponent {

	private MutableIntObjectMap<ResendConfig> configTable = IntObjectHashMap.newMap();

	@Value("${backup.config.file.resend}")
	private String configFileName;

	@PostConstruct
	private void init() throws FileNotFoundException {
		InputStream resourceAsStream = ResendConfigComponent.class.getClassLoader().getResourceAsStream(configFileName);
		try {
			List<ResendConfig> resendConfigList = JsonSerializationUtil
					.jsonToList(JsonSerializationUtil.InputStreamToJson(resourceAsStream), ResendConfig.class);
			resendConfigList.forEach(config -> configTable.put(config.getProcessId(), config));
		} catch (IOException e) {
			log.error("Read file {} throws IOException.", configTable, e);
			throw new AtgoException(e.getMessage(), e);
		}
	}

	public ResendConfig getResendConfig(int processId) {
		return configTable.get(processId);
	}

	public Collection<ResendConfig> getResendConfigs() {
		return configTable.values();
	}

}
