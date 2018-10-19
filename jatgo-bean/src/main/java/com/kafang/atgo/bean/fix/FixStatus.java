package com.kafang.atgo.bean.fix;

import java.time.LocalDateTime;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.base.FixRequiredFieldMissingException;
import com.kafang.atgo.bean.fix.enums.ModuleStatus;
import com.kafang.atgo.bean.fix.enums.MsgType;
import com.kafang.atgo.bean.fix.field.FixStatusField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public final class FixStatus extends BaseFixBean<FixStatusField> {

	private LocalDateTime sendingTime;
	private int clientId;
	private int moduleStatus;

	public FixStatus() {
		super(MsgType.ReportStatus);
	}

	public FixStatus(FixMessage message) throws FixMessageAnalysisException {
		super(message);
	}

	@Override
	public ImmutableList<FixStatusField> getFixFields() {
		return FixFieldLists.FixStatusFields;
	}

	@Override
	protected void setAttributes() {
		setSendingTime((LocalDateTime) getValue(FixStatusField.SendingTime)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixStatusField.SendingTime)));
		setClientId((int) getValue(FixStatusField.ClientID)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixStatusField.ClientID)));
		setModuleStatus((int) getValue(FixStatusField.ModuleStatus).orElse(ModuleStatus.Invalid.code()));
	}

	@Override
	protected MutableMap<FixStatusField, Object> attributesToMap() {
		MutableMap<FixStatusField, Object> map = newMap();
		map.put(FixStatusField.SendingTime, getSendingTime());
		map.put(FixStatusField.ClientID, getClientId());
		map.put(FixStatusField.ModuleStatus, getModuleStatus());
		return map;
	}

}
