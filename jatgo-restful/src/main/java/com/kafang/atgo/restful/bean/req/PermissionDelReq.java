package com.kafang.atgo.restful.bean.req;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @author like
 * @description 资源删除bean
 * @data 2018/10/18
 */
@Getter
@Setter
@ToString
public class PermissionDelReq {

    @ApiParam(name = "资源ids")
    @QueryParam("ids")
    private List<Long> ids;
}
