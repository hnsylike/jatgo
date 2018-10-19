package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixResendRequestField implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	ProcessID(GeneralFixFields.FixField_ProcessID),

	;

	private GeneralFixField generalFixField;

	private FixResendRequestField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;

	}

	@Override
	public GeneralFixField getGeneralFixField() {
		return generalFixField;
	}

}
