package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.restful.dao.api.WsAuditTrailDao;
import com.kafang.atgo.restful.entity.WsAuditTrail;
import com.kafang.atgo.restful.service.api.WsAuditTrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WsAuditTrailServiceImpl implements WsAuditTrailService {

	@Autowired
	private WsAuditTrailDao agDao;
	
	@Override
	public int insert(WsAuditTrail ws) {
		return agDao.insert(ws);
	}
	
}
