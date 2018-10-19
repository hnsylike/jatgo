package com.kafang.atgo.bean.fix.enums;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum CxlType implements FixEnum {

	Invalid(-1),

	NotCanceled(0),

	StopTrade(1),

	StopInit(2),

	;

	private int code;

	private CxlType(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

}
