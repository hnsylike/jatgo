package com.kafang.atgo.restful.resource;

import com.kafang.atgo.restful.base.AtgoRestfulApi;
import com.kafang.atgo.restful.bean.rep.PermissionConfigBean;
import com.kafang.atgo.restful.bean.rep.PermissionRep;
import com.kafang.atgo.restful.bean.req.PermissionDelReq;
import com.kafang.atgo.restful.bean.req.PermissionInfoReq;
import com.kafang.atgo.restful.bean.req.PermissionPageReq;
import com.kafang.atgo.restful.config.PermissionConfig;
import com.kafang.atgo.restful.dto.rep.PageDto;
import com.kafang.atgo.restful.dto.rep.ResponseTemplate;
import com.kafang.atgo.restful.entity.WsPermission;
import com.kafang.atgo.restful.service.api.WsPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.List;

/**
 * @author like
 * @description 资源api
 * @data 2018/10/17
 */
@Api(value = " permission Rest Api")
@Slf4j
@Path("/permission")
@Component
public class PermissionRestfulApi extends AtgoRestfulApi {

    @Autowired
    private WsPermissionService wsPermissionService;

    @Autowired
    private PermissionConfig permissionConfig;

    /**
     * 根据ids删除资源
     *
     * @return
     */
    @POST
    @Path("/deleteById")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    @ApiOperation(value = "根据ids删除资源rest api", notes = "rest api")
    public ResponseTemplate<Integer> del(PermissionDelReq req) {
        return ResponseTemplate.ok(wsPermissionService.del(req.getIds()));
    }

    /**
     * 根据查询条件查询Permission信息
     *
     * @return
     */
    @POST
    @Path("/queryByParam")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    @ApiOperation(value = "根据查询条件查询Permission信息rest api", notes = "rest api")
    public ResponseTemplate<PageDto<WsPermission>> queryByParam(PermissionPageReq permissionReq) {
        return ResponseTemplate.ok(wsPermissionService.queryByParam(permissionReq));
    }

    /**
     * 根据id查询Permission
     *
     * @param id
     * @return
     */
    @GET
    @Path("/queryById/{id}")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    @ApiOperation(value = "根据id查询Permission信息 rest api", notes = "rest api")
    public ResponseTemplate<PermissionRep> queryById(@ApiParam(required = true, name = "主键id") @PathParam("id") Long id) {
        return ResponseTemplate.ok(wsPermissionService.queryById(id));
    }

    /**
     * 保存或更新资源
     *
     * @param permissionInfoReq
     * @return
     */
    @POST
    @Path("/saveOrUpdate")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    @ApiOperation(value = "保存或更新资源rest api", notes = "rest api")
    public ResponseTemplate<Integer> saveOrUpdate(PermissionInfoReq permissionInfoReq) {
        return ResponseTemplate.ok(wsPermissionService.saveOrUpdate(permissionInfoReq));
    }

    /**
     * 查询缓存中所有Permission
     *
     * @return
     */
    @GET
    @Path("/queryAllPermission")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    @ApiOperation(value = "根据id查询Permission信息 rest api", notes = "rest api")
    public ResponseTemplate<List<PermissionConfigBean>> queryAllPermission() {
        return ResponseTemplate.ok(permissionConfig.querAllPermission());
    }

    /**
     * 刷新缓存Permission
     *
     * @return
     */
    @GET
    @Path("/refreshPermission")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    @ApiOperation(value = "根据id查询Permission信息 rest api", notes = "rest api")
    public ResponseTemplate<List<PermissionConfigBean>> refreshPermission() {
        return ResponseTemplate.ok(permissionConfig.refreshPermission());
    }

}
