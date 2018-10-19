package com.kafang.atgo.risk.validators;

import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.risk.base.BaseRiskValidator;

/**
 * 多账户自成交验证
 * 
 * @author Phoenix
 *
 */
public class SelfTradeInMultipleAccountValidator extends BaseRiskValidator<FixOrder> {

	@Override
	public boolean validationOrder(FixOrder inOrder) {
		return false;
	}

	@Override
	public String getValidatorName() {
		return this.getClass().getSimpleName();
	}

}
