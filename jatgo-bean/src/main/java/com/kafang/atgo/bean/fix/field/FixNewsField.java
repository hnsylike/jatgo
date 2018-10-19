package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixNewsField implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	SendingTime(GeneralFixFields.FixField_SendingTime),

	Urgency(GeneralFixFields.FixField_Urgency),

	Headline(GeneralFixFields.FixField_Headline),

	Text(GeneralFixFields.FixField_Text),

	;

	private GeneralFixField generalFixField;

	private FixNewsField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;

	}

	@Override
	public GeneralFixField getGeneralFixField() {
		return generalFixField;
	}

}
