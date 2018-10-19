package com.kafang.atgo.restful.service.api;

import java.util.Map;

public interface AgStrategyParamL3Service {
	
	Map<Integer, Map<String, String>> selectById(int strategyId);

}
