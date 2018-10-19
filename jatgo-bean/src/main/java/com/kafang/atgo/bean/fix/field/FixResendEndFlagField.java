package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixResendEndFlagField  implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	;

	private GeneralFixField generalFixField;

	private FixResendEndFlagField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;

	}

	@Override
	public GeneralFixField getGeneralFixField() {
		return generalFixField;
	}

}