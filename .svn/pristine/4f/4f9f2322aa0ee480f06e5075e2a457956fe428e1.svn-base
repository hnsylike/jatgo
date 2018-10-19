package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.persistence.db.dao.api.AgAccountDao;
import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.restful.service.api.AgAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AgAccountServiceImpl implements AgAccountService {

	@Autowired
	private AgAccountDao agDao;
	
	@Override
	public AgAccount selectByStrategyId(int strategyId) {
		return agDao.selectById(strategyId).orElse(null);
	}

	@Override
	public AgAccount selectByAccountId(long accountId) {
		return agDao.selectByAccountId(accountId).orElse(null);
	}

	@Override
	public List<AgAccount> selectByStrategy(int strategyId) {
		return agDao.selectByStrategyId(strategyId).orElse(Collections.emptyList());
	}

	@Override
	public int insert(AgAccount agAccount) {
		return agDao.insert(agAccount);
	}

	@Override
	public String selectid() {
		return agDao.selectid();
	}
	
	
}
