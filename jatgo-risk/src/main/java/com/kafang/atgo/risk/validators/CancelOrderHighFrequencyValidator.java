package com.kafang.atgo.risk.validators;

import com.kafang.atgo.bean.fix.FixCancelOrder;
import com.kafang.atgo.risk.base.BaseRiskValidator;

public class CancelOrderHighFrequencyValidator extends BaseRiskValidator<FixCancelOrder> {

	@Override
	public boolean validationOrder(final FixCancelOrder inOrder) {
		
		
		return false;
	}

	public static void main(String[] args) {


	}

	@Override
	public String getValidatorName() {
		return this.getClass().getSimpleName();
	}

}
