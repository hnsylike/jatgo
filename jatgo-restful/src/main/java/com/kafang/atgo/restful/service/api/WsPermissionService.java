package com.kafang.atgo.restful.service.api;

import com.kafang.atgo.restful.bean.rep.PermissionRep;
import com.kafang.atgo.restful.bean.req.PermissionInfoReq;
import com.kafang.atgo.restful.bean.req.PermissionPageReq;
import com.kafang.atgo.restful.dto.rep.PageDto;
import com.kafang.atgo.restful.entity.WsPermission;
import com.kafang.atgo.restful.entity.WsRolePermission;

import java.util.List;

public interface WsPermissionService {

    int del(List<Long> ids);

    /**
     * 根据查询条件查询Permission信息
     * @return
     */
    PageDto<WsPermission> queryByParam(PermissionPageReq permissionReq);

    /**
     * 根据id查询Permission
     * @param id
     * @return
     */
    PermissionRep queryById(Long id);

    /**
     * 保存或更新
     * @param permissionInfoReq
     * @return
     */
    int saveOrUpdate(PermissionInfoReq permissionInfoReq);

    /**
     * 查询所有Permission信息
     * @return
     */
    List<WsPermission> queryAll();

    /**
     * 根据资源id查询资源角色列表
     * @param permissionIds
     * @return
     */
    List<WsRolePermission> queryByPermissionIds(List<Long> permissionIds);
}
