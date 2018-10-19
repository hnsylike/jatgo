package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixStatusField implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	SendingTime(GeneralFixFields.FixField_SendingTime),

	ClientID(GeneralFixFields.FixField_ClientID),

	ModuleStatus(GeneralFixFields.FixField_ModuleStatus),

	;

	private GeneralFixField generalFixField;

	private FixStatusField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;

	}

	@Override
	public GeneralFixField getGeneralFixField() {
		return generalFixField;
	}

}
