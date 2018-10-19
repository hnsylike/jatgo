package com.kafang.atgo.bean.fix.enums;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum SpecTreat implements FixEnum {

	Invalid(-1),

	Normal(0),

	ST(1),

	STStar(2),

	;

	private int code;

	private SpecTreat(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

}
