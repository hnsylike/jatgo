package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixHeartbeatField implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	SendingTime(GeneralFixFields.FixField_SendingTime),

	TransactTime(GeneralFixFields.FixField_TransactTime),

	;

	private GeneralFixField generalFixField;

	private FixHeartbeatField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;

	}

	@Override
	public GeneralFixField getGeneralFixField() {

		return generalFixField;
	}

}
