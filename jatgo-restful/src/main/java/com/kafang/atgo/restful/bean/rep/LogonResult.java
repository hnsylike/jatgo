package com.kafang.atgo.restful.bean.rep;

import com.kafang.atgo.restful.entity.WsUser;

import java.util.Optional;

public class LogonResult {

	private boolean success;

	private Optional<WsUser> wsUser;
	
	private String token;
	
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LogonResult(boolean success) {
		super();
		this.success = success;
	}

	public Optional<WsUser> getWsUser() {
		return wsUser;
	}

	public LogonResult setWsUser(WsUser wsUser) {
		this.wsUser = Optional.ofNullable(wsUser);
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

}
