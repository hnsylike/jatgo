package com.kafang.atgo.restful.bean.req;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.QueryParam;

/**
 * @author like
 * @description 资源查询bean
 * @data 2018/10/17
 */

@Getter
@Setter
@ToString
public class PermissionPageReq {

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
     * 当前页
     */
    @ApiParam(name = "当前页")
    @QueryParam("pageNo")
    private Integer pageNo;

    /**
     * 每页条数
     */
    @ApiParam(name = "每页条数")
    @QueryParam("pageSize")
    private Integer pageSize;

}
