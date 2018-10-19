package com.kafang.atgo.risk.validators;

import com.kafang.atgo.bean.fix.base.BizOrder;
import com.kafang.atgo.bean.fix.enums.ModuleStatus;
import com.kafang.atgo.risk.base.BaseRiskValidator;

public class AdaptorValidator extends BaseRiskValidator<BizOrder> {

	@Override
	public String getValidatorName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public boolean validationOrder(BizOrder inOrder) {
		return statusStorage.getStatus(inOrder.getAccountId()).getModuleStatus() == ModuleStatus.Online.code();
	}

}
