package com.kafang.atgo.bean.fix.enums;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.immutable.primitive.ImmutableIntObjectMapFactoryImpl;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

import com.kafang.atgo.bean.fix.base.FixEnum;

public enum OrdType implements FixEnum {

	Invalid(-1),

	Limit(0),

	CreditLimit(1),

	TWAP(101),

	VWAP(102),

	;

	private int code;

	private OrdType(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

	private final static ImmutableIntObjectMap<OrdType> map;
	static {
		MutableIntObjectMap<OrdType> tempMap = IntObjectHashMap.newMap();
		for (OrdType ordType : OrdType.values()) {
			tempMap.put(ordType.code, ordType);
		}
		map = ImmutableIntObjectMapFactoryImpl.INSTANCE.withAll(tempMap);
	}

	public static OrdType checkout(int code) {
		if (map.containsKey(code)) {
			return map.get(code);
		}
		throw new NoSuchElementException("code -> (" + code + ") not find element.");
	}

}
