package com.kafang.atgo.restful.service.impl;

import com.kafang.atgo.restful.dao.api.WsRoleDao;
import com.kafang.atgo.restful.entity.WsRole;
import com.kafang.atgo.restful.service.api.WsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author like
 * @description 角色service
 * @data 2018/10/17
 */
@Service
public class WsRoleServiceImpl implements WsRoleService {
    @Autowired
    private WsRoleDao wsRoleDao;

    @Override
    public List<WsRole> queryAll() {
        return wsRoleDao.queryAll().orElse(Collections.emptyList());
    }
}
