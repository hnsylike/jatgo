package com.kafang.atgo.risk.validators;

import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.memory.utils.InstrumentIdHelper;
import com.kafang.atgo.risk.base.BaseRiskValidator;

public class OrderPriceValidator extends BaseRiskValidator<FixOrder> {

	@Override
	public boolean validationOrder(FixOrder inOrder) {
		return marketDataStorage
				.getInstrumentInfo(
						InstrumentIdHelper.getInstrumentId(inOrder.getSecurityExchange(), inOrder.getSymbol()))
				// 检查报价是否大于涨停价或低于跌停价
				.map(instrumentInfo -> instrumentInfo.getUpPrice() >= inOrder.getPrice()
						&& instrumentInfo.getDownPrice() <= inOrder.getPrice())
				.orElse(false);
	}

	@Override
	public String getValidatorName() {
		return this.getClass().getSimpleName();
	}

}
