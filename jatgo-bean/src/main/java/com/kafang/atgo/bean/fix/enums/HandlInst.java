package com.kafang.atgo.bean.fix.enums;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.immutable.primitive.ImmutableIntObjectMapFactoryImpl;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum HandlInst implements FixEnum {

	Invalid(-1),

	Actual(1),

	Uncensored(2),

	Algo(3),

	;

	private int code;

	private HandlInst(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

	private final static ImmutableIntObjectMap<HandlInst> map;
	static {
		MutableIntObjectMap<HandlInst> tempMap = IntObjectHashMap.newMap();
		for (HandlInst handInst : HandlInst.values()) {
			tempMap.put(handInst.code, handInst);
		}
		map = ImmutableIntObjectMapFactoryImpl.INSTANCE.withAll(tempMap);
	}

	public static HandlInst checkout(int code) {
		if (map.containsKey(code)) {
			return map.get(code);
		}
		throw new NoSuchElementException("code -> (" + code + ") not find element.");
	}
}
