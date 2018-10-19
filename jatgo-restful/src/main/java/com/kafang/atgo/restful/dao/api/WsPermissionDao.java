package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.bean.req.PermissionPageReq;
import com.kafang.atgo.restful.entity.WsPermission;

import java.util.List;
import java.util.Optional;

public interface WsPermissionDao {

    int insert(WsPermission wsPermission);

    int del(long id);

    int update(WsPermission wsPermission);

    /**
     * 根据id查询Permission
     * @param id
     * @return
     */
    Optional<WsPermission> queryById(Long id);

    /**
     * 根据ids查询Permission
     * @param ids
     * @return
     */
    Optional<List<WsPermission>> queryByIds(List<Long> ids);

    /**
     * 根据permissionId查询Permission
     * @param permissionId
     * @return
     */
    Optional<WsPermission> queryByPermissionId(Long permissionId);

    /**
     * 根据url和method查询Permission信息
     * @return
     */
    Optional<List<WsPermission>> queryByUrlAndMethod(String permissionUrl, String permissionMethod);

    /**
     * 查询所有Permission信息
     * @return
     */
    Optional<List<WsPermission>> queryByParam(PermissionPageReq permissionReq, Long offset, Long limit);

    /**
     * 统计Permission信息
     * @param permissionReq
     * @return
     */
    long count(PermissionPageReq permissionReq);

    /**
     * 查询所有Permission信息
     * @return
     */
    Optional<List<WsPermission>> queryAll();
}
