package com.kafang.atgo.bean.fix.enums;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.immutable.primitive.ImmutableIntObjectMapFactoryImpl;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum Side implements FixEnum {

	Invalid(-1),

	Buy(1),

	Sell(2),

	;

	private int code;

	private Side(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

	private final static ImmutableIntObjectMap<Side> map;
	static {
		MutableIntObjectMap<Side> tempMap = IntObjectHashMap.newMap();
		for (Side side : Side.values()) {
			tempMap.put(side.code, side);
		}
		map = ImmutableIntObjectMapFactoryImpl.INSTANCE.withAll(tempMap);
	}

	public static Side checkout(int code) {
		if (map.containsKey(code)) {
			return map.get(code);
		}
		throw new NoSuchElementException("code -> (" + code + ") not find element.");
	}

}
