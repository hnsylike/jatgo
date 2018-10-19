package com.kafang.atgo.restful.service.api;

import com.kafang.atgo.restful.entity.RptNominal;

import java.util.Date;
import java.util.List;

public interface RptNominalService {

	List<RptNominal> selectByCustomer(int customerId, int strategyId, Date stime, Date endtime);
	
}
