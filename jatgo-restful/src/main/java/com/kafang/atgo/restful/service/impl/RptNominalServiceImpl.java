package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.restful.dao.api.RptNominalDao;
import com.kafang.atgo.restful.dao.api.WsUserCustomerMpDao;
import com.kafang.atgo.restful.entity.RptNominal;
import com.kafang.atgo.restful.entity.WsUserCustomerMp;
import com.kafang.atgo.restful.service.api.RptNominalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RptNominalServiceImpl implements RptNominalService {

	@Autowired
	private WsUserCustomerMpDao wsDao;

	@Autowired
	private RptNominalDao agDao;

	@Override
	public List<RptNominal> selectByCustomer(int userId, int strategyId,Date stime,Date endtime) {
		Optional<WsUserCustomerMp> opt=wsDao.selectByUserId(userId);
		WsUserCustomerMp ws = opt.get(); 
		return  agDao.selectByCustomer(ws.getCustomerId(), strategyId, stime,endtime).orElse(Collections.emptyList());
	}

}
