package com.kafang.atgo.restful.bean.req;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.QueryParam;

@Getter
@Setter
@ToString
public class LogonReq {

	/**
	 * 用户名
	 */
	@ApiParam(name = "用户名", required = true)
	@QueryParam("username")
	private String username;

	/**
	 * 密码
	 */
	@ApiParam(name = "密码", required = true)
	@QueryParam("password")
	private String password;

	/**
	 * 手机号
	 */
	@ApiParam(name = "手机号", required = true)
	@QueryParam("phone")
	private String phone;

	/**
	 * 验证码
	 */
	@ApiParam(name = "验证码", required = true)
	@QueryParam("smsCode")
	private Integer smsCode;


}
