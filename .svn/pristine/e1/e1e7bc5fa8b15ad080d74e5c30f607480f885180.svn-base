package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixPositionField implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	SendingTime(GeneralFixFields.FixField_SendingTime),

	TransactTime(GeneralFixFields.FixField_TransactTime),

	ClientID(GeneralFixFields.FixField_ClientID),

	Symbol(GeneralFixFields.FixField_Symbol),

	SecurityType(GeneralFixFields.FixField_SecurityType),

	SecurityExchange(GeneralFixFields.FixField_SecurityExchange),

	CurrentQty(GeneralFixFields.FixField_CurrentQty),

	TradableQty(GeneralFixFields.FixField_TradableQty),

	ShortQty(GeneralFixFields.FixField_ShortQty),

	;

	private GeneralFixField generalFixField;

	private FixPositionField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;
	}

	@Override
	public GeneralFixField getGeneralFixField() {
		return generalFixField;
	}

}
