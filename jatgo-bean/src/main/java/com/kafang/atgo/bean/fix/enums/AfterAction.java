package com.kafang.atgo.bean.fix.enums;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum AfterAction implements FixEnum {

	Invalid(-1),

	No(0),

	Yes(1),

	;

	private int code;

	private AfterAction(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

}
