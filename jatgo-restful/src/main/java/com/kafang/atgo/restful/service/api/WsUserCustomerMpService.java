package com.kafang.atgo.restful.service.api;


import com.kafang.atgo.restful.entity.WsUserCustomerMp;

import java.util.List;

public interface WsUserCustomerMpService {
	WsUserCustomerMp getCustomerId(long id);
	
	int update(WsUserCustomerMp wsUserCustomerMp);
	
	int del(long id);
	
	int insert(WsUserCustomerMp wcm);
	
	String selectCustomerId();
	
	String selectUserId();
	
	List<WsUserCustomerMp> getByClientId(List<Integer> clientIds) ;
}
