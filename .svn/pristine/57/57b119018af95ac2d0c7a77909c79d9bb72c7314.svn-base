package com.kafang.atgo.restful.service.api;

import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.restful.bean.rep.LogonResult;
import com.kafang.atgo.restful.entity.AgClient;
import com.kafang.atgo.restful.entity.WsPhone;
import com.kafang.atgo.restful.entity.WsUser;
import com.kafang.atgo.restful.entity.WsUserRole;

import java.util.List;

public interface UserService {

	 List<WsUser> getAllUser();

	// logon method
	 LogonResult logon(String username, String password);

	 WsUser getPhone(String phone, String username);

	//查询登录用户所以产品名
	List<AgClient> getCustomer(int userid);
	
	//根据产品名查询所对应的策略
	List<AgAccount> getStrategy(int customerid);
	
	int insert(WsUser wu);
	
	int insertphone(WsPhone wp);
	
	int del(long id);
	
	String selectUserId();
	
	List<WsUser> getUser(long customerid);
	
	List<WsPhone> getPhone(long userid);
	
	WsUser getid(long id);
	
	WsUser getUserId(int userid);
	
	int update(WsUser wu);

	List<WsUser> getUsername(String username);

	WsPhone getPhone(String phone);

	List<WsUserRole> queryByUserId(List<Long> userIds);

	int saveUserRoles(List<WsUserRole> wsUserRoles);

}
