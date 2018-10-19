package com.kafang.atgo.restful.service.api;

import com.kafang.atgo.restful.entity.WsRole;

import java.util.List;

public interface WsRoleService {

    /**
     * 查询所有role信息
     * @return
     */
    List<WsRole> queryAll();
}
