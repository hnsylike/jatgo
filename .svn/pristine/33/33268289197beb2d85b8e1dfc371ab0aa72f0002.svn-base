package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.WsRole;

import java.util.List;
import java.util.Optional;

public interface WsRoleDao {

    int insert(WsRole wsRole);

    int del(long id);

    int update(WsRole wsRole);

    /**
     * 根据roleId查询role
     * @param roleIds
     * @return
     */
    Optional<List<WsRole>> queryByRoleIds(List<Long> roleIds);

    /**
     * 查询所有role信息
     * @return
     */
    Optional<List<WsRole>> queryAll();
}
