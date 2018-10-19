package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.restful.dao.api.RptActualDao;
import com.kafang.atgo.restful.dao.api.WsUserCustomerMpDao;
import com.kafang.atgo.restful.entity.RptActual;
import com.kafang.atgo.restful.entity.WsUserCustomerMp;
import com.kafang.atgo.restful.service.api.RptActualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RptActualServiceImpl  implements RptActualService {

	@Autowired
	private WsUserCustomerMpDao wsDao;

	@Autowired
	private RptActualDao agDao;
	
	@Override
	public List<RptActual> selectByCustomer(int userId, int strategyId, String stime,String endtime) {
		Optional<WsUserCustomerMp> opt=wsDao.selectByUserId(userId);
		WsUserCustomerMp ws = opt.get();
		return agDao.selectByCustomer(ws.getCustomerId(), strategyId, stime,endtime).orElse(Collections.emptyList());
	}
}
