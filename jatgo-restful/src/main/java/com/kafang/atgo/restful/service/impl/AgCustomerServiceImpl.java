package com.kafang.atgo.restful.service.impl;


import com.kafang.atgo.persistence.db.dao.api.AgAccountDao;
import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.restful.dao.api.*;
import com.kafang.atgo.restful.entity.*;
import com.kafang.atgo.restful.service.api.AgCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AgCustomerServiceImpl implements AgCustomerService {
	@Autowired
	private WsUserCustomerMpDao userCustomerMpDao;

	@Autowired
	private AgCustomerDao customerDao;

	@Autowired
	private WsUserDao wsUserDao;

	@Autowired
	private WsPhoenDao wsPhoneDao;

	@Autowired
	private AgClientDao clientDao;

	@Autowired
	private AgAccountDao accountDao;
	
	@Override
	public AgCustomer getId(int customerId) {
		return customerDao.selectById(customerId).orElse(null);
	}

	@Override
	public List<AgCustomer> getAll() {
		return customerDao.selectAll().orElse(Collections.emptyList());
	}

	@Override
	public int insert(AgCustomer ac) {
		return customerDao.insert(ac);
	}

	@Override
	public List<AgCustomer> getCustomerName(String customerName) {
		return customerDao.selectByCustomerName(customerName).orElse(Collections.emptyList());
	}
	
	@Override
	public AgCustomer selectByCustomerName(String customerName) {
		return customerDao.selectByCustomer(customerName).orElse(null);
	}

	@Override
	public String selectCustomerId() {
		return customerDao.selectCustomerId();
	}

	@Override
	public int delCustomerUser(int userId) {
		Optional<WsUserCustomerMp> wcm= userCustomerMpDao.selectByUserId(userId);
		if(!wcm.isPresent()) {
			return 0;
		}
		WsUserCustomerMp wcmp=wcm.get();
		Optional<WsUser> wu=wsUserDao.selectByUserId(userId);
		if (!wu.isPresent()){
			return 0;
		}
		WsUser wsu=wu.get();
		Optional<WsPhone> wp=wsPhoneDao.selectByUserId(userId);
		if(!wp.isPresent()) {
			return 0;
		}
		WsPhone wsphone=wp.get();
		wsPhoneDao.del(wsphone.getId());
		wsUserDao.del(wsu.getId());
		return userCustomerMpDao.del(wcmp.getId());
	}

	@Override
	public int delClient(int id) {
		Optional<AgClient> aclient=clientDao.selectById(id);
		AgClient agc=aclient.get();
		Optional<AgAccount> aga=accountDao.selectByClient(agc.getClientId());
		AgAccount acc=aga.get();
		accountDao.del(acc.getId());
		return clientDao.del(agc.getId());
	}

	public int delCustomer(int customerId) {
		Optional<AgCustomer> opt= customerDao.selectId(customerId);
		if (!opt.isPresent()){
			return 0;
		}
		AgCustomer ac=opt.get();
		return customerDao.del(ac.getId());
	}

}
