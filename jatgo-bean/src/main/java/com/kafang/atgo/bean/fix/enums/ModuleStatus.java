package com.kafang.atgo.bean.fix.enums;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum ModuleStatus implements FixEnum {

	Invalid(-1),

	Online(0),

	Offline(1),

	Initializing(2),

	;

	private int code;

	private ModuleStatus(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

}
