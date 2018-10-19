package com.kafang.atgo.risk.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.json.JsonSerializationUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NewOrderFrequencyConfigComponent {

	private MutableSetMultimap<Integer, NewOrderFrequencyConfig> configTable = UnifiedSetMultimap.newMultimap();

	@Value("${risk.config.file.NewOrderFrequency}")
	private String configFileName;

	@PostConstruct
	private void init() throws FileNotFoundException {
		InputStream resourceAsStream = NewOrderFrequencyConfigComponent.class.getClassLoader()
				.getResourceAsStream(configFileName);
		try {
			List<NewOrderFrequencyConfig> resendConfigList = JsonSerializationUtil.jsonToList(
					JsonSerializationUtil.InputStreamToJson(resourceAsStream), NewOrderFrequencyConfig.class);
			resendConfigList.forEach(config -> configTable.put(config.getInstrumentId(), config));
		} catch (IOException e) {
			log.error("Read file {} throws IOException.", configTable, e);
			throw new AtgoException(e.getMessage(), e);
		}
	}

	public MutableSet<NewOrderFrequencyConfig> getNewOrderFrequencyConfigs(int instrumentId) {
		if (configTable.containsKey(instrumentId)) {
			return configTable.get(instrumentId);
		}
		return configTable.get(-1);
	}

}
