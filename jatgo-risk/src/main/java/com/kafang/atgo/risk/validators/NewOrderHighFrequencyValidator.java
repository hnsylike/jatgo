package com.kafang.atgo.risk.validators;

import java.time.Instant;

import org.eclipse.collections.api.set.MutableSet;

import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.memory.avro.record.Order;
import com.kafang.atgo.memory.utils.InstrumentIdHelper;
import com.kafang.atgo.risk.base.BaseRiskValidator;
import com.kafang.atgo.risk.config.NewOrderFrequencyConfig;

import io.ffreedom.common.utils.DoubleUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewOrderHighFrequencyValidator extends BaseRiskValidator<FixOrder> {

	@Override
	public boolean validationOrder(FixOrder inOrder) {
		long inOrderNowEpochSecond = Instant.now().getEpochSecond();
		MutableSet<Order> orders4Client = orderStorage
				.getOrders4Client(accountManager.getClientId(inOrder.getAccountId()));
		MutableSet<NewOrderFrequencyConfig> frequencyConfigs = newOrderFrequencyConfigComponent
				.getNewOrderFrequencyConfigs(
						InstrumentIdHelper.getInstrumentId(inOrder.getSecurityExchange(), inOrder.getSymbol()));
		return frequencyConfigs.stream().peek(frequencyConfig -> log.info(
				"Check order according to -> frequencyConfig[seconds=={}, limitOrder=={}, limitQty=={}, limitAmount=={}]",
				frequencyConfig.getSeconds(), frequencyConfig.getLimitOrder(), frequencyConfig.getLimitQty(),
				frequencyConfig.getLimitAmount())).map(frequencyConfig -> {
					MutableSet<Order> inFrequencyOrders = orders4Client.select(
							order -> order.getLocalTimestamp() > inOrderNowEpochSecond - frequencyConfig.getSeconds());
					if (inFrequencyOrders.isEmpty()) {
						log.info("Select order result inFrequencyOrders.isEmpty()==true for seconds==[{}]",
								frequencyConfig.getSeconds());
						return true;
					} else {
						log.info(
								"Select order result inFrequencyOrders.size()=={} for seconds==[{}], Max LimitOrder [{}]",
								inFrequencyOrders.size(), frequencyConfig.getLimitOrder());
						return inFrequencyOrders.size() < frequencyConfig.getLimitOrder()
								&& inFrequencyOrders
										.tap(order -> log.info(
												"Select order detail -> clOrdId==[{}], orderQty==[{}], price==[{}]",
												order.getClOrdId(), order.getOrderQty(), order.getPrice()))
										.sumOfInt(order -> order.getOrderQty()) < frequencyConfig.getLimitQty()
								&& inFrequencyOrders.sumOfDouble(order -> DoubleUtil.multiply4(order.getOrderQty(),
										order.getPrice())) < frequencyConfig.getLimitAmount();
					}
				}).mapToInt(bool -> bool ? 0 : 1).sum() == 0;
	}

	@Override
	public String getValidatorName() {
		return this.getClass().getSimpleName();
	}

}
