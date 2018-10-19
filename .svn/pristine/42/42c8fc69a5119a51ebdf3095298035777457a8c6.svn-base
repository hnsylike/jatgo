package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.persistence.db.dao.api.AgAccountDao;
import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.restful.dao.api.AgStrategyParamL3Dao;
import com.kafang.atgo.restful.entity.AgStrategyParamL3;
import com.kafang.atgo.restful.service.api.AgStrategyParamL3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgStrategyParamL3ServiceImpl implements AgStrategyParamL3Service {

	@Autowired
	private AgStrategyParamL3Dao agDao;

	@Autowired
	private AgAccountDao acDao;
	
	@Override
	public Map<Integer, Map<String, String>> selectById(int strategyId) {
		Optional<List<AgAccount>> opt=acDao.selectByStrategyId(strategyId);
		if (!opt.isPresent()) {
			return new HashMap<>();
		}
		List<AgAccount> ws = opt.get(); 
		Optional<List<AgStrategyParamL3>> asp=agDao.selectByStrategyId(ws.stream().map(AgAccount::getStrategyId).collect(Collectors.toList()));
		List<AgStrategyParamL3> ag3=asp.get();
		Map<Integer, Map<String, String>> m = new HashMap<>();
		Map<String, String> m1 = new HashMap<>();
		for(AgStrategyParamL3 a1:ag3) {
			m1.put("ParamName",a1.getName());
			m1.put("ParamValue",a1.getValue());
			//m.put(ws.getAccountID(), m1);
		}
		return m;
	}

}
