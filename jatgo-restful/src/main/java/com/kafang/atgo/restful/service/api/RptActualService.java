package com.kafang.atgo.restful.service.api;

import com.kafang.atgo.restful.entity.RptActual;

import java.util.List;

public interface RptActualService {
	
	List<RptActual> selectByCustomer(int customerId, int strategyId, String stime, String endtime);
}
