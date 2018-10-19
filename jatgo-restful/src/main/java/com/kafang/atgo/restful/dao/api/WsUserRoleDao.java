package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.WsUserRole;

import java.util.List;
import java.util.Optional;

public interface WsUserRoleDao {

    int insert(WsUserRole wsUserRole);

    int del(long id);

    int update(WsUserRole wsUserRole);

    /**
     * 根据userId查询userRole
     * @param userIds
     * @return
     */
    Optional<List<WsUserRole>> queryByUserIds(List<Long> userIds);

    /**
     * 根据roleId查询userRole
     * @param roleIds
     * @return
     */
    Optional<List<WsUserRole>> queryByRoleIds(List<Long> roleIds);

    /**
     * 查询所有userRole信息
     * @return
     */
    Optional<List<WsUserRole>> queryAll();
}
