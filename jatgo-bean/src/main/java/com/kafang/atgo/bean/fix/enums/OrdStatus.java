package com.kafang.atgo.bean.fix.enums;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.immutable.primitive.ImmutableIntObjectMapFactoryImpl;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum OrdStatus implements FixEnum {

	Invalid(-1, "无效"),

	New(0, "已报单-已确认"),

	PartialFill(1, "部分成交"),

	Filled(2, "全部成交"),

	Canceled(4, "已撤单"),

	PendingCancel(6, "已撤单-未确认"),

	Rejected(8, "拒绝"),

	PendingNew(10, "已报单-未确认"),

	;

	private int code;

	private String zhCnDescription;

	public int getCode() {
		return code;
	}

	public String getZhCnDescription() {
		return zhCnDescription;
	}

	private OrdStatus(int code, String zhCnDescription) {
		this.code = code;
		this.zhCnDescription = zhCnDescription;
	}

	public int code() {
		return code;
	}

	private final static ImmutableIntObjectMap<OrdStatus> map;
	static {
		MutableIntObjectMap<OrdStatus> tempMap = IntObjectHashMap.newMap();
		for (OrdStatus ordStatus : OrdStatus.values()) {
			tempMap.put(ordStatus.code, ordStatus);
		}
		map = ImmutableIntObjectMapFactoryImpl.INSTANCE.withAll(tempMap);
	}

	public static OrdStatus checkout(int code) {
		if (map.containsKey(code)) {
			return map.get(code);
		}
		throw new NoSuchElementException("code -> (" + code + ") not find element.");
	}

}
