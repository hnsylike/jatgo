package com.kafang.atgo.risk.validators;

import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.bean.fix.enums.Side;
import com.kafang.atgo.memory.avro.record.Position;
import com.kafang.atgo.memory.utils.InstrumentIdHelper;
import com.kafang.atgo.risk.base.BaseRiskValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewOrderQtyValidator extends BaseRiskValidator<FixOrder> {

	@Override
	public boolean validationOrder(FixOrder inOrder) {
		Side side = Side.checkout(inOrder.getSide());
		switch (side) {
		case Buy:
			return validationOrderBuy(inOrder);
		case Sell:
			return validationOrderSell(inOrder);
		default:
			log.error("Side Code -> {} is {}", inOrder.getSide(), side);
			return false;
		}
	}

	private boolean validationOrderBuy(FixOrder inOrder) {
		// 买入数量为整百
		return inOrder.getOrderQty() % 100 == 0;
	}

	private boolean validationOrderSell(FixOrder inOrder) {
		Position position = positionStorage.getPosition(inOrder.getAccountId(),
				InstrumentIdHelper.getInstrumentId(inOrder.getSecurityExchange(), inOrder.getSymbol()));
		// 卖出数量小于可卖量且低于百股的零散股数等于可卖量的零散股数
		return inOrder.getOrderQty() > position.getTradableQty()
				&& inOrder.getOrderQty() % 100 == position.getTradableQty() % 100;
	}

	@Override
	public String getValidatorName() {
		return this.getClass().getSimpleName();
	}

}
