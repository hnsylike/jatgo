package com.kafang.atgo.risk.validators;

import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.risk.base.BaseRiskValidator;

import io.ffreedom.common.utils.DoubleUtil;

public final class BalanceValidator extends BaseRiskValidator<FixOrder> {

	@Override
	public boolean validationOrder(FixOrder inOrder) {
		return DoubleUtil.multiply4(inOrder.getPrice(), inOrder.getOrderQty()) < balanceStorage
				.getBalance(inOrder.getAccountId()).getEnableBalance();
	}

	@Override
	public String getValidatorName() {
		return this.getClass().getSimpleName();
	}

}
