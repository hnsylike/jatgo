package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.AtgoErrorCode;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.db.dao.api.AgAccountDao;
import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.restful.bean.rep.LogonResult;
import com.kafang.atgo.restful.dao.api.*;
import com.kafang.atgo.restful.entity.*;
import com.kafang.atgo.restful.service.api.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private WsUserDao wsUserDao;

	@Autowired
	private WsPhoenDao wsPhoenDao;

	@Autowired
	private WsUserCustomerMpDao wcmDao;

	@Autowired
	private AgCustomerDao acDao;

	@Autowired
	private AgClientDao agClientDao;

	@Autowired
	private AgAccountDao agDao;

	@Autowired
	private AgStrategyDao agStrategtyDao;

	@Autowired
	private WsUserRoleDao wsUserRoleDao;

	/*
	 * public User getUserById(int userId) {
	 * return this.userDao.selectByPrimaryKey(userId); }
	 */

	@Override
	public List<WsUser> getAllUser() {
		return wsUserDao.selectAll().orElse(Collections.emptyList());
	}

	@Override
	public LogonResult logon(String username, String password) {
		Optional<WsUser> wsUserOptional = wsUserDao.selectByUsername(username);
		return wsUserOptional.filter(user -> user.getPassword().equals(password)).isPresent()
				? new LogonResult(true).setWsUser(wsUserOptional.get())
				: new LogonResult(false);
	}

	@Override
	public WsUser getPhone(String phone,String username) {
		Optional<WsPhone> phoneOptional = wsPhoenDao.selectByPhone(phone);
		if (!phoneOptional.isPresent()) {
			throw new AtgoException(AtgoErrorCode.REQUEST_PARAMETER_ERROR,"该用户没有这个手机号");
		}
		WsPhone wsPhone = phoneOptional.get(); 
		Optional<WsUser> opt =wsUserDao.selectById(wsPhone.getUserId());
		if (!opt.isPresent()) {
			return new WsUser();
		}
		WsUser wu = opt.get(); 
		return wu;
	}

	@Override
	public List<AgClient> getCustomer(int userid) {
		Optional<WsUserCustomerMp> opt=wcmDao.selectByUserId(userid);
		if (!opt.isPresent()) {
			return new ArrayList<>();
		}
		WsUserCustomerMp wcm=opt.get();
		Optional<AgCustomer> agCustomer=acDao.selectById(wcm.getCustomerId());
		if(!agCustomer.isPresent()) {
			return new ArrayList<>();
		}
		AgCustomer ac=agCustomer.get();
		return agClientDao.selectByCustomer(ac.getCustomerId()).orElse(Collections.emptyList());
	}

	@Override
	public List<AgAccount> getStrategy(int clientId) {
		/*Optional<AgClient> agClient=agClientDao.selectById(clientId);
		if(!agClient.isPresent()) {
			return new ArrayList<>();
		}
		AgClient agClients=agClient.get();*/
		return agDao.selectByClientId(clientId).orElse(Collections.emptyList());
	}

	@Override
	public int insert(WsUser wu) {
		return wsUserDao.insert(wu);
	}

	@Override
	public int insertphone(WsPhone wp) {
		return wsPhoenDao.insert(wp);
	}

	@Override
	public int del(long id) {
		return wsUserDao.del(id);
	}

	@Override
	public String selectUserId() {
		return wsUserDao.selectUserId();
	}

	@Override
	public List<WsUser> getUser(long customerid) {
		Optional<List<WsUserCustomerMp>> opt=wcmDao.getCustomer(customerid);
		if (!opt.isPresent()) {
			return Collections.emptyList();
		}
		List<WsUserCustomerMp> wcm=opt.get();
		Optional<List<WsUser>> user=wsUserDao.getuser(wcm.stream().map(WsUserCustomerMp::getUserId).collect(Collectors.toList()));
		if(!user.isPresent()) {
			return Collections.emptyList();
		}
		List<WsUser> list=user.get();
		return list;
	}

	@Override
	public List<WsPhone> getPhone(long customerid) {
		Optional<List<WsUserCustomerMp>> opt=wcmDao.getCustomer(customerid);
		if (!opt.isPresent()) {
			return new ArrayList<>();
		}
		List<WsUserCustomerMp> wcm=opt.get();
		if(CollectionUtils.isEmpty(wcm)){
			return new ArrayList<>();
		}
		Optional<List<WsUser>> user=wsUserDao.getuser(wcm.stream().map(WsUserCustomerMp::getUserId).collect(Collectors.toList()));
		if(!user.isPresent()) {
			return new ArrayList<>();
		}
		List<WsUser> list=user.get();
		Optional<List<WsPhone>> wp=wsUserDao.getphone(list.stream().map(WsUser::getUserid).collect(Collectors.toList()));
		if(!wp.isPresent()) {
			return new ArrayList<>();
		}
		List<WsPhone> wplist=wp.get();
		return wplist;
	}

	@Override
	public WsUser getid(long id) {
		return wsUserDao.getid(id).orElse(null);
	}

	@Override
	public WsUser getUserId(int userid) {
		return  wsUserDao.selectByUserId(userid).orElse(null);
	}

	@Override
	public int update(WsUser wu) {
		return wsUserDao.update(wu);
	}

	@Override
	public List<WsUser> getUsername(String username) {
		return wsUserDao.getUsername(username).orElse(Collections.emptyList());
	}

	@Override
	public WsPhone getPhone(String phone) {
		return wsPhoenDao.selectByPhone(phone).orElse(null);
	}

	@Override
	public List<WsUserRole> queryByUserId(List<Long> userIds) {
		return wsUserRoleDao.queryByUserIds(userIds).orElse(Collections.emptyList());
	}

	@Override
	public int saveUserRoles(List<WsUserRole> wsUserRoles) {
		int result = 0;
		for(WsUserRole wsUserRole : wsUserRoles) {
			result += wsUserRoleDao.insert(wsUserRole);
		}
		return result;
	}

}
