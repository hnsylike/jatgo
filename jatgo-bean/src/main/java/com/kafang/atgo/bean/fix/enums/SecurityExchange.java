package com.kafang.atgo.bean.fix.enums;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum SecurityExchange implements FixEnum {

	Invalid(-1),

	SZ(1),

	SH(2),

	;

	private int code;

	private SecurityExchange(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

}
