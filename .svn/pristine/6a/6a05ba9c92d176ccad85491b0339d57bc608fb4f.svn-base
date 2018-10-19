package com.kafang.atgo.bean.fix.field;

import com.kafang.atgo.bean.fix.base.FixField;
import com.kafang.atgo.bean.fix.base.GeneralFixField;
import com.kafang.atgo.bean.fix.base.GeneralFixFields;

public enum FixInstrumentInfoField implements FixField {

	MsgType(GeneralFixFields.FixField_MsgType),

	SendingTime(GeneralFixFields.FixField_SendingTime),

	TransactTime(GeneralFixFields.FixField_TransactTime),

	Symbol(GeneralFixFields.FixField_Symbol),

	SecurityType(GeneralFixFields.FixField_SecurityType),

	SecurityExchange(GeneralFixFields.FixField_SecurityExchange),

	UpPx(GeneralFixFields.FixField_UpPx),

	DownPx(GeneralFixFields.FixField_DownPx),

	TickSize(GeneralFixFields.FixField_TickSize),

	LotSize(GeneralFixFields.FixField_LotSize),

	SpecTreat(GeneralFixFields.FixField_SpecTreat),

	;
	private GeneralFixField generalFixField;

	private FixInstrumentInfoField(GeneralFixField generalFixField) {
		this.generalFixField = generalFixField;
	}

	@Override
	public GeneralFixField getGeneralFixField() {
		return generalFixField;
	}

}
