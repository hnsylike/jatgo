package com.kafang.atgo.restful.dto;

import java.io.Serializable;

//产品名所对应的策略
public class ConfAuthDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//
	
	private String customer;//

	private String accountUID;//

	private String isAuth;//

	private String account; // 账号名称

	private String strategy; // 策略名称

	private String param; // 参数列表

	private String clientName;
	
	private String strategyName;
	
	
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAccountUID() {
		return accountUID;
	}

	public void setAccountUID(String accountUID) {
		this.accountUID = accountUID;
	}

	public String getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(String isAuth) {
		this.isAuth = isAuth;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ConfAuthDto [id=" + id + ", customer=" + customer + ", accountUID=" + accountUID + ", isAuth=" + isAuth
				+ ", account=" + account + ", strategy=" + strategy + ", param=" + param + ", clientName=" + clientName
				+ ", strategyName=" + strategyName + "]";
	}


	

}
