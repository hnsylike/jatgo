package com.kafang.atgo.bean.fix;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.base.FixRequiredFieldMissingException;
import com.kafang.atgo.bean.fix.enums.MsgType;
import com.kafang.atgo.bean.fix.field.FixResendRequestField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class FixResendRequest extends BaseFixBean<FixResendRequestField> {

	private int processId;

	public FixResendRequest() {
		super(MsgType.ResendRequest);
	}

	public FixResendRequest(FixMessage message) throws FixMessageAnalysisException {
		super(message);
	}

	@Override
	public ImmutableList<FixResendRequestField> getFixFields() {
		return FixFieldLists.FixResendRequestFields;
	}

	@Override
	protected void setAttributes() {
		setProcessId((int) getValue(FixResendRequestField.ProcessID)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixResendRequestField.ProcessID)));
	}

	@Override
	protected MutableMap<FixResendRequestField, Object> attributesToMap() {
		MutableMap<FixResendRequestField, Object> map = newMap();
		map.put(FixResendRequestField.ProcessID, getProcessId());
		return map;
	}

}
