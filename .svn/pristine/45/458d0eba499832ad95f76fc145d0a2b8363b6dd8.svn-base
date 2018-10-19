package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixCancelOrderField implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	SendingTime(GeneralFixFields.FixField_SendingTime),

	TransactTime(GeneralFixFields.FixField_TransactTime),

	HandlInst(GeneralFixFields.FixField_HandlInst),

	OrigClOrdID(GeneralFixFields.FixField_OrigClOrdID),

	OrderID(GeneralFixFields.FixField_OrderID),

	ClOrdID(GeneralFixFields.FixField_ClOrdID),

	AccountID(GeneralFixFields.FixField_AccountID),

	ClientID(GeneralFixFields.FixField_ClientID),

	CxlType(GeneralFixFields.FixField_CxlType),
	
	OrdStatus(GeneralFixFields.FixField_OrdStatus),
	
	CxlRejReason(GeneralFixFields.FixField_CxlRejReason),

	;

	private GeneralFixField generalFixField;

	private FixCancelOrderField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;

	}

	@Override
	public GeneralFixField getGeneralFixField() {

		return generalFixField;
	}

}
