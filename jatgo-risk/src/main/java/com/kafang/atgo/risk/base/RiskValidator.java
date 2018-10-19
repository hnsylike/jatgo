package com.kafang.atgo.risk.base;

import com.kafang.atgo.bean.fix.base.BizOrder;

public interface RiskValidator<O extends BizOrder> {

	String getValidatorName();

	boolean validationOrder(final O inOrder);

}
