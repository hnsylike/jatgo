package com.kafang.atgo.restful.resource;

import com.kafang.atgo.restful.base.AtgoRestfulApi;
import com.kafang.atgo.restful.dto.rep.ResponseTemplate;
import com.kafang.atgo.restful.entity.WsRole;
import com.kafang.atgo.restful.service.api.WsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * @author like
 * @description 角色rest api
 * @data 2018/10/17
 */

@Api(value = " role Rest Api")
@Slf4j
@Path("/role")
@Component
public class RoleRestfulApi extends AtgoRestfulApi {

    @Autowired
    private WsRoleService wsRoleService;

    /**
     * 显示所有角色
     *
     * @return
     */
    @GET
    @Path("/queryCustomer")
    @Produces(JSON_UTF8)
    @Consumes(JSON_UTF8)
    @ApiOperation(value = "显示所有角色rest api", notes = "rest api")
    public ResponseTemplate<List<WsRole>> findAll() {
        return ResponseTemplate.ok(wsRoleService.queryAll());
    }

}
