package com.kafang.atgo.restful.entity;


/**
 * 此枚举类用于维护操作日志到AuditTrail表字段optype类型.
 */
public enum OpType {
	
	Login("登录操作"),
	
	Logout("登出操作"),
	
	AddAlgo("下母单操作"),
	
	CancelAlgo("撤销母单操作"),
	
	ApproveAlgo("母单审核操作"),
	
	AddUser("添加用户操作"),
	
	AddCustomer("添加客户机构操作"),
	
	AddClient("添加母账户操作"),
	
	DelUser("删除用户操作"),
	
	DelCustomer("删除客户机构操作"),
	
	DelClient("删除母账户操作");
	
	private String chineseName;

	public String getChineseName() {
		return chineseName;
	}

	private OpType(String chineseName) {
		this.chineseName = chineseName;
	}
	
}
