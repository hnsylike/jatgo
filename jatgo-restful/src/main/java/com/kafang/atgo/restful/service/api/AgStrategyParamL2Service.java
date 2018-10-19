package com.kafang.atgo.restful.service.api;
import java.util.Map;

public interface AgStrategyParamL2Service {
	Map<Integer, Map<String, String>> selectById(int strategyId);
	
	Map<Integer, Map<String, String>> selectByStrategyId(int strategyId);
}
