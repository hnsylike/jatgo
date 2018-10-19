package com.kafang.atgo.restful.service.api;

import com.kafang.atgo.restful.entity.RptStrategy;

import java.util.Date;
import java.util.List;

public interface RptStrategyService {
	
	List<RptStrategy> selectByCustomer(int customerId, int strategyId, Date stime, Date endtime);
	
}
