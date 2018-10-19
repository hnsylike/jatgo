package com.kafang.atgo.restful.service.api;


import com.kafang.atgo.persistence.db.entity.AgAccount;

import java.util.List;

public interface AgAccountService {
	
	List<AgAccount> selectByStrategy(int strategyId);
	
	AgAccount selectByStrategyId(int strategyId);
	
	AgAccount selectByAccountId(long accountId);
	
	int insert(AgAccount agAccount);
	
	public String selectid();
}
