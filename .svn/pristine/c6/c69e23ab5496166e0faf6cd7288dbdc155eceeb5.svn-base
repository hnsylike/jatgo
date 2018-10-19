package com.kafang.atgo.risk.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafang.atgo.bean.fix.base.BizOrder;
import com.kafang.atgo.memory.container.BalanceStorage;
import com.kafang.atgo.memory.container.MarketDataStorage;
import com.kafang.atgo.memory.container.OrderStorage;
import com.kafang.atgo.memory.container.PositionStorage;
import com.kafang.atgo.memory.container.StatusStorage;
import com.kafang.atgo.memory.manager.AccountManager;
import com.kafang.atgo.risk.config.NewOrderFrequencyConfigComponent;

@Component
public abstract class BaseRiskValidator<O extends BizOrder> implements RiskValidator<O> {

	@Autowired
	protected AccountManager accountManager;

	@Autowired
	protected StatusStorage statusStorage;

	@Autowired
	protected BalanceStorage balanceStorage;

	@Autowired
	protected PositionStorage positionStorage;

	@Autowired
	protected OrderStorage orderStorage;

	@Autowired
	protected MarketDataStorage marketDataStorage;

	@Autowired
	protected NewOrderFrequencyConfigComponent newOrderFrequencyConfigComponent;

}
