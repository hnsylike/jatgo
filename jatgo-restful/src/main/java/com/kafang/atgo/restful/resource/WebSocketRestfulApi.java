package com.kafang.atgo.restful.resource;

import com.kafang.atgo.restful.base.AtgoRestfulApi;
import com.kafang.atgo.restful.dto.rep.ResponseTemplate;
import com.kafang.atgo.restful.service.WebSocketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author like
 * @description webSocketApi Rest Api测试
 * @data 2018/9/29
 */
@Api(value = "webSocketApi Rest Api测试")
@Slf4j
@Path("/webSocket")
@Component
public class WebSocketRestfulApi extends AtgoRestfulApi {

	@Autowired
	private WebSocketService webSocketService;

	/**
	 * 查询所有clientId或userId对应的机器ip
	 *
	 * @return
	 */
	@GET
	@Path("/queryAllInfo")
	@Produces(JSON_UTF8)
	@ApiOperation(value = "查询所有clientId或userId对应的机器ip", notes = "rest api")
	public ResponseTemplate<ConcurrentMap<String, CopyOnWriteArraySet<WebSocketService>>> findAll() {
		ConcurrentMap<String, CopyOnWriteArraySet<WebSocketService>> map = webSocketService.getClientInfoAll();
		return ResponseTemplate.ok(map);
	}

	/**
	 * 查询所有连接webSocket连接的机器ip
	 *
	 * @return
	 */
	@GET
	@Path("/queryAllClient")
	@ApiOperation(value = "查询所有连接webSocket连接的机器ip", notes = "rest api")
	@Produces(JSON_UTF8)
	public ResponseTemplate<List<String>> find() {
		List<String> list = webSocketService.getClientAll();
		return ResponseTemplate.ok(list);
	}
}
