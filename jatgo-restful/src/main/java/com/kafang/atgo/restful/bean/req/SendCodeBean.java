package com.kafang.atgo.restful.bean.req;

import com.kafang.atgo.restful.entity.WsUser;
import com.kafang.atgo.restful.entity.WsUserRole;

import java.time.LocalDateTime;
import java.util.List;

public class SendCodeBean {

	/**
	 * 
	 */
	private String token;
	private String phoneNumber;
	private int code;
	private LocalDateTime expiredTime;
	private LocalDateTime tokenTime;
	private WsUser wsUser;
	private List<WsUserRole> wsUserRoleList;

	private SendCodeBean(String phoneNumber, int code, LocalDateTime expiredTime) {
		super();
		this.phoneNumber = phoneNumber;
		this.code = code;
		this.expiredTime = expiredTime;
	}

	private SendCodeBean(String token, LocalDateTime tokenTime) {
		super();
		this.token = token;
		this.tokenTime = tokenTime;
	}

	public static SendCodeBean newWith(String phoneNumber, int code, LocalDateTime expiredTime) {
		return new SendCodeBean(phoneNumber, code, expiredTime);
	}

	public static SendCodeBean newToken(String token, LocalDateTime tokenTime) {
		return new SendCodeBean(token, tokenTime);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getCode() {
		return code;
	}

	public LocalDateTime getExpiredTime() {
		return expiredTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getTokenTime() {
		return tokenTime;
	}

	public void setTokenTime(LocalDateTime tokenTime) {
		this.tokenTime = tokenTime;
	}

	public WsUser getWsUser() {
		return wsUser;
	}

	public void setWsUser(WsUser wsUser) {
		this.wsUser = wsUser;
	}

	public List<WsUserRole> getWsUserRoleList() {
		return wsUserRoleList;
	}

	public void setWsUserRoleList(List<WsUserRole> wsUserRoleList) {
		this.wsUserRoleList = wsUserRoleList;
	}
}
