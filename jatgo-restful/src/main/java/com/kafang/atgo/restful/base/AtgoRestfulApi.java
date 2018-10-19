package com.kafang.atgo.restful.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.io.IOUtils;

import com.kafang.atgo.persistence.json.JsonSerializationUtil;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public abstract class AtgoRestfulApi implements RestfulApi {

	/**
	 * 检查参数列表
	 * 
	 * @param objs
	 * @return
	 */
	protected boolean checkParamIsNull(Object... objs) {
		for (Object obj : objs) {
			if (obj != null) {
				return false;
			}
		}
		return true;
	}

	protected String getRequestStr(HttpServletRequest request) {
		try {
			return IOUtils.toString(request.getInputStream(), UTF8);
		} catch (IOException e) {
			log.error("", e);
			return null;
		}
	}

	/**
	 * Http Status Code: 400 Bad Request
	 * 
	 * @return
	 */
	protected Response httpBadRequest() {
		return setCors(Response.status(Status.BAD_REQUEST));
	}

	/**
	 * Http Status Code: 400 Bad Request
	 * 
	 * @return
	 */
	protected Response httpNotFound() {
		return setCors(Response.status(Status.NOT_FOUND));
	}

	/**
	 * Http Status Code: 500 Internal Server Error
	 * 
	 * @return
	 */
	protected Response httpInternalServerError() {
		return setCors(Response.status(Status.INTERNAL_SERVER_ERROR));
	}

	/**
	 * Http Status Code: 500 Internal Server Error
	 * 
	 * @return
	 */
	protected Response httpResponse(int httpStatusCode) {
		return setCors(Response.status(httpStatusCode));
	}

	/**
	 * Http Status Code: 200 Ok
	 * 
	 * @return
	 */
	protected Response httpOk() {
		return setCors(Response.status(Status.OK));
	}

	protected Response jsonResponse(Object object) {
		if (object == null) {
			return httpInternalServerError();
		}
		return setCors(Response.ok(JsonSerializationUtil.objToJson(object)));
	}

	private Response setCors(ResponseBuilder builder) {
		return builder
				//.header("Access-Control-Allow-Origin", "*")
				//.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
				//.header("Access-Control-Allow-Credentials", "true")
				//.header("Access-Control-Max-Age", "1209600")
				.build();
	}

}
