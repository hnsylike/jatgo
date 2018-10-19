package com.kafang.atgo.bean.fix.enums;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.mutable.MutableMapFactoryImpl;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum MsgType implements FixEnum {

	Heartbeat("0"),

	ResendRequest("2"),

	ResendEndFlag("EF"),

	InstrumentInfo("II"),

	MarketDataLevel1("W"),

	Order("D"),

	OrderReport("8"),

	CancelOrder("F"),

	CancelOrderReport("9"),

	ReportPosition("RP"),

	ReportBalance("RB"),

	ReportStatus("RS"),

	News("B"),

	;

	private String code;

	private MsgType(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}

	private final static MutableMap<String, MsgType> map = MutableMapFactoryImpl.INSTANCE.empty();
	static {
		for (MsgType ordStatus : MsgType.values()) {
			map.put(ordStatus.code, ordStatus);
		}
	}

	public static MsgType checkout(String code) {
		if (map.containsKey(code)) {
			return map.get(code);
		}
		throw new NoSuchElementException("Invalid MsgType -> " + code);
	}

}
