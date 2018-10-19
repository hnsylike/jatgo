package com.kafang.atgo.bean.fix.enums;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum SecurityType implements FixEnum {

	Invalid(-1),

	CS(00),

	ETF(15),

	CB(12),

	RB(13),

	IDX(20),

	IF(21),

	;

	private int code;

	private SecurityType(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

}
