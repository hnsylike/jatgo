package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.restful.dao.api.AgClientDao;
import com.kafang.atgo.restful.dao.api.AgCustomerDao;
import com.kafang.atgo.restful.dao.api.WsOrderInsDao;
import com.kafang.atgo.restful.dao.api.WsUserCustomerMpDao;
import com.kafang.atgo.restful.entity.AgClient;
import com.kafang.atgo.restful.entity.AgCustomer;
import com.kafang.atgo.restful.entity.WsOrderIns;
import com.kafang.atgo.restful.entity.WsUserCustomerMp;
import com.kafang.atgo.restful.service.api.OrderInsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderInsServiceImpl implements OrderInsService {

	@Autowired
	private WsOrderInsDao woDao ;

	@Autowired
	private WsUserCustomerMpDao wDao;

	@Autowired
	private AgCustomerDao customerDao;

	@Autowired
	private AgClientDao clientDao;
	
	
	@Override
	public int insert(WsOrderIns wsOrderIns) {
		return woDao.insert(wsOrderIns);
	}
	
	@Override
	public int update(WsOrderIns wsOrderIns) {
		return woDao.update(wsOrderIns);
	}

	@Override
	public List<WsOrderIns> queryAll() {
		return woDao.selectAll().orElse(Collections.emptyList());
	}

	@Override
	public List<WsOrderIns> selectByReview(int userid) {
		Optional<WsUserCustomerMp> opt=wDao.selectById(userid);
		if (!opt.isPresent()) {
			return new ArrayList<>();
		}
		WsUserCustomerMp ws = opt.get(); 
		Optional<AgCustomer> customer=customerDao.selectById(ws.getCustomerId());
		if (!customer.isPresent()) {
			return new ArrayList<>();
		}
		AgCustomer cu = customer.get(); 
		Optional<AgClient> client=clientDao.selectById(cu.getCustomerId());
		if (!client.isPresent()) {
			return new ArrayList<>();
		}
		AgClient ac = client.get(); 
		return woDao.selectByReview(ac.getClientId()).orElse(Collections.emptyList());
		
	}

	@Override
	public List<WsOrderIns> selectById(long id) {
		return woDao.selectById(id).orElse(Collections.emptyList());
	}


}
