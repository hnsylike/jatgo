package com.kafang.atgo.bean.fix.base;

import java.time.LocalDateTime;
import java.util.Optional;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

import com.kafang.atgo.AtgoException;
import com.kafang.atgo.bean.fix.enums.MsgType;

import io.ffreedom.common.charset.AsciiCharacter;
import io.ffreedom.common.datetime.DateTimeUtil;
import io.ffreedom.common.utils.StringUtil;

public abstract class BaseFixBean<K extends FixField> implements FixBean<K> {

	private MsgType msgType;

	private MutableIntObjectMap<Optional<Object>> intObjectMap = new IntObjectHashMap<>();

	protected BaseFixBean(MsgType msgType) {
		this.msgType = msgType;
	}

	protected BaseFixBean(FixMessage fixMessage) throws FixMessageAnalysisException {
		this(fixMessage.getMsgType(), fixMessage);
	}

	protected BaseFixBean(MsgType msgType, FixMessage fixMessage) throws FixMessageAnalysisException {
		if (msgType == null) {
			throw new IllegalArgumentException("msgType Not allowed to be null.");
		}
		this.msgType = msgType;
		if (fixMessage != null) {
			fromFixMessage(fixMessage);
		}
	}

	public MsgType getMsgType() {
		return msgType;
	}

	@Override
	public void fromFixMessage(FixMessage fixMessage) throws FixMessageAnalysisException {
		try {
			ImmutableIntObjectMap<String> fixFieldsMap = fixMessage.getFixFieldsMap();
			for (K field : getFixFields()) {
				GeneralFixField fixField = field.getGeneralFixField();
				int tag = fixField.tag();
				FixFieldType type = fixField.type();
				if (fixFieldsMap.containsKey(tag)) {
					switch (type) {
					case INT:
						intObjectMap.put(tag, Optional.of(Integer.parseInt(fixFieldsMap.get(tag))));
						break;
					case DOUBLE:
						intObjectMap.put(tag, Optional.of(Double.parseDouble(fixFieldsMap.get(tag))));
						break;
					case STRING:
						intObjectMap.put(tag, Optional.of(fixFieldsMap.get(tag)));
						break;
					case DATETIME:
						intObjectMap.put(tag,
								Optional.of(DateTimeUtil.toLocalDateTime(Long.parseLong(fixFieldsMap.get(tag)))));
						break;
					case LONG:
						intObjectMap.put(tag, Optional.of(Long.parseLong(fixFieldsMap.get(tag))));
						break;
					default:
					}
				} else {
					intObjectMap.put(tag, Optional.empty());
				}
			}
			setAttributes();
		} catch (Exception e) {
			throw new FixMessageAnalysisException(e.getMessage(), e);
		}
	}

	private boolean isInvalid(int value) {
		return value < 0;
	}

	private boolean isInvalid(long value) {
		return value < 0L;
	}

	private boolean isInvalid(double value) {
		return value < 0.0D;
	}

	private boolean isInvalid(String str) {
		return StringUtil.isNullOrEmpty(str);
	}

	private boolean isInvalid(LocalDateTime value) {
		return value == null;
	}

	@Override
	public String toFixMessage() throws FixBeanLegalityException {
		StringBuilder fixMessage = new StringBuilder();
		try {
			MutableMap<K, Object> attributesMap = attributesToMap();
			appendFixMessage(fixMessage, GeneralFixFields.FixField_MsgType.tag(), msgType.code());
			if (attributesMap != null) {
				for (K key : attributesMap.keySet()) {
					GeneralFixField fixField = key.getGeneralFixField();
					Object value = attributesMap.get(key);
					switch (fixField.type()) {
					case INT:
						if (!isInvalid((int) value)) {
							appendFixMessage(fixMessage, fixField.tag(), value);
						}
						break;
					case LONG:
						if (!isInvalid((long) value)) {
							appendFixMessage(fixMessage, fixField.tag(), value);
						}
						break;
					case DOUBLE:
						if (!isInvalid((double) value)) {
							appendFixMessage(fixMessage, fixField.tag(), value);
						}
						break;
					case STRING:
						if (!isInvalid((String) value)) {
							appendFixMessage(fixMessage, fixField.tag(), value);
						}
						break;
					case DATETIME:
						if (!isInvalid((LocalDateTime) value)) {
							appendFixMessage(fixMessage, fixField.tag(),
									DateTimeUtil.datetimeToMillisecond((LocalDateTime) value));
						}
						break;
					default:
						throw new AtgoException("Unknown type -> " + fixField.type());
					}
				}
			}
		} catch (Exception e) {
			throw new FixBeanLegalityException(e);
		}
		return fixMessage.toString();
	}

	private void appendFixMessage(StringBuilder fixMessage, int tag, Object value) {
		fixMessage.append(tag);
		fixMessage.append("=");
		fixMessage.append(value);
		fixMessage.append(AsciiCharacter.SOH);
	}

	protected abstract void setAttributes();

	protected abstract MutableMap<K, Object> attributesToMap();

	protected MutableMap<K, Object> newMap() {
		return new UnifiedMap<>();
	}

	protected Optional<Object> getValue(K k) {
		return intObjectMap.get(k.getGeneralFixField().tag());
	}

}
