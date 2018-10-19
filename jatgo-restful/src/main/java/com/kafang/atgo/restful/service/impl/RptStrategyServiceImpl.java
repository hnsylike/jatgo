package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.restful.dao.api.RptStrategyDao;
import com.kafang.atgo.restful.dao.api.WsUserCustomerMpDao;
import com.kafang.atgo.restful.entity.RptStrategy;
import com.kafang.atgo.restful.entity.WsUserCustomerMp;
import com.kafang.atgo.restful.service.api.RptStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RptStrategyServiceImpl implements RptStrategyService {

	@Autowired
	private WsUserCustomerMpDao wsDao;

	@Autowired
	private RptStrategyDao agDao;
	
	@Override
	public List<RptStrategy> selectByCustomer(int userId, int strategyId, Date stime,Date endtime) {
		Optional<WsUserCustomerMp> opt=wsDao.selectByUserId(userId);
		WsUserCustomerMp ws = opt.get();
		return  agDao.selectByCustomer(ws.getCustomerId(), strategyId, stime,endtime).orElse(Collections.emptyList());
	}
	
	
	
}
