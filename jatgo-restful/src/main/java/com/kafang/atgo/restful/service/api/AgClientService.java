package com.kafang.atgo.restful.service.api;

import com.kafang.atgo.restful.entity.AgClient;

import java.util.List;

public interface AgClientService {
	AgClient getId(int id);
	
	List<AgClient> getByCustomerId(long customerId);

	List<AgClient> getByUserId(long customerId);

	int insert(AgClient agClient);
	
	String selectid();

}
