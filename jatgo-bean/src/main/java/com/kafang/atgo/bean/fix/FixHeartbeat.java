package com.kafang.atgo.bean.fix;

import java.time.LocalDateTime;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.base.FixRequiredFieldMissingException;
import com.kafang.atgo.bean.fix.field.FixHeartbeatField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class FixHeartbeat extends BaseFixBean<FixHeartbeatField> {

	private LocalDateTime sendingTime;
	private LocalDateTime transactTime;

	public FixHeartbeat(FixMessage fixMessage) throws FixMessageAnalysisException {
		super(fixMessage);
	}

	@Override
	public ImmutableList<FixHeartbeatField> getFixFields() {
		return FixFieldLists.FixHeartbeatFields;
	}

	@Override
	protected void setAttributes() {
		setSendingTime((LocalDateTime) getValue(FixHeartbeatField.SendingTime)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixHeartbeatField.SendingTime)));
		setTransactTime((LocalDateTime) getValue(FixHeartbeatField.TransactTime)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixHeartbeatField.TransactTime)));
	}

	@Override
	protected MutableMap<FixHeartbeatField, Object> attributesToMap() {
		MutableMap<FixHeartbeatField, Object> map = newMap();
		map.put(FixHeartbeatField.SendingTime, getSendingTime());
		map.put(FixHeartbeatField.TransactTime, getTransactTime());
		return map;
	}

}
