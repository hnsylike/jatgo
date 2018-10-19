package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixBalanceField implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	SendingTime(GeneralFixFields.FixField_SendingTime),

	ClientID(GeneralFixFields.FixField_ClientID),

	TransactTime(GeneralFixFields.FixField_TransactTime),
	
	EnableBalance(GeneralFixFields.FixField_EnableBalance),
	
	CreditBalance(GeneralFixFields.FixField_CreditBalance),

	;

	private GeneralFixField generalFixField;

	private FixBalanceField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;
	}

	@Override
	public GeneralFixField getGeneralFixField() {
		return generalFixField;
	}

}
