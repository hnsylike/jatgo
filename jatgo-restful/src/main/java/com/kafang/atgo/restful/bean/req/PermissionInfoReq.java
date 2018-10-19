package com.kafang.atgo.restful.bean.req;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @author like
 * @description 资源查询bean
 * @data 2018/10/17
 */
@Getter
@Setter
@ToString
public class PermissionInfoReq {

    /**
     * id
     */
    @ApiParam(name = "主键id")
    @QueryParam("id")
    private Long id;

    /**
     * 资源id
     */
    @ApiParam(name = "资源id")
    @QueryParam("permissionId")
    private Long permissionId;

    /**
     * 资源地址
     */
    @ApiParam(name = "资源地址")
    @QueryParam("permissionUrl")
    private String permissionUrl;

    /**
     * 资源名称
     */
    @ApiParam(name = "资源名称")
    @QueryParam("permissionName")
    private String permissionName;

    /**
     * 资源方法
     */
    @ApiParam(name = "资源方法")
    @QueryParam("permissionMethod")
    private String permissionMethod;

    /**
     * 是否白名单
     */
    @ApiParam(name = "是否白名单")
    @QueryParam("white")
    private Boolean white;

    /**
     * 角色的资源列表
     */
    @ApiParam(name = "角色的资源列表")
    @QueryParam("rolePermissions")
    private List<RolePermission> rolePermissions;

    @Getter
    @Setter
    public static class RolePermission {

        @ApiParam(name = "角色资源id")
        @QueryParam("id")
        private Long id;

        @ApiParam(name = "角色id")
        @QueryParam("roleId")
        private Long roleId;

    }
}
