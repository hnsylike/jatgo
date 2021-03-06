package com.kafang.atgo.restful.service.impl;
import com.kafang.atgo.persistence.db.dao.api.AgAccountDao;

import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.restful.dao.api.AgStrategyParamL1Dao;
import com.kafang.atgo.restful.entity.AgStrategyParamL1;
import com.kafang.atgo.restful.service.api.AgStrategyParamL1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgStrategyParamL1ServiceImpl implements AgStrategyParamL1Service {

	@Autowired
	private AgStrategyParamL1Dao agDao;

	@Autowired
	private AgAccountDao acDao;
	

	public List<AgStrategyParamL1> selectById(int strategyId){
		Optional<List<AgAccount>> opt=acDao.selectByStrategyId(strategyId);
		if (!opt.isPresent()) {
			return new ArrayList<>();
		}
		List<AgAccount> list = opt.get();
		Optional<List<AgStrategyParamL1>> asp=agDao.selectByAccountId(list.stream().map(AgAccount::getStrategyId).collect(Collectors.toList()));
		List<AgStrategyParamL1> l1=asp.get();
		return l1;
	}

}
