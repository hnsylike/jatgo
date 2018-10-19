package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.WsRolePermission;

import java.util.List;
import java.util.Optional;

public interface WsRolePermissionDao {

    int insert(WsRolePermission wsRolePermission);

    int del(long id);

    int update(WsRolePermission wsRolePermission);

    /**
     * 根据roleIds查询RolePermission
     * @param roleIds
     * @return
     */
    Optional<List<WsRolePermission>> queryByRoleIds(List<Long> roleIds);

    /**
     * 根据permissionIds查询RolePermission
     * @param permissionIds
     * @return
     */
    Optional<List<WsRolePermission>> queryByPermissionIds(List<Long> permissionIds);

}
