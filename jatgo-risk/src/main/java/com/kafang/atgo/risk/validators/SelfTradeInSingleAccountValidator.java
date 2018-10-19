package com.kafang.atgo.risk.validators;

import org.eclipse.collections.api.set.MutableSet;

import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.bean.fix.enums.OrdStatus;
import com.kafang.atgo.bean.fix.enums.Side;
import com.kafang.atgo.memory.avro.record.Order;
import com.kafang.atgo.memory.utils.InstrumentIdHelper;
import com.kafang.atgo.risk.base.BaseRiskValidator;

import lombok.extern.slf4j.Slf4j;

/**
 * 单账户自成交验证
 * 
 * @author Phoenix
 *
 */
@Slf4j
public class SelfTradeInSingleAccountValidator extends BaseRiskValidator<FixOrder> {

	@Override
	public boolean validationOrder(FixOrder inOrder) {
		MutableSet<Order> orders4Client = orderStorage
				.getOrders4Client(accountManager.getClientId(inOrder.getAccountId()));
		int instrumentId = InstrumentIdHelper.getInstrumentId(inOrder.getSecurityExchange(), inOrder.getSymbol());
		Side side = Side.checkout(inOrder.getSide());
		switch (side) {
		case Buy:
			MutableSet<Order> sellOrders = selectOrder(orders4Client, instrumentId, Side.Sell);
			return sellOrders.isEmpty() ? true
					: sellOrders
							.tap(order -> log.info("sell order -> clOrdId == {}, price == {}", order.getClOrdId(),
									order.getPrice()))
							.collectDouble(order -> order.getPrice()).min() < inOrder.getPrice();
		case Sell:
			MutableSet<Order> buyOrders = selectOrder(orders4Client, instrumentId, Side.Buy);
			return buyOrders.isEmpty() ? true
					: buyOrders
							.tap(order -> log.info("buy order -> clOrdId == {}, price == {}", order.getClOrdId(),
									order.getPrice()))
							.collectDouble(order -> order.getPrice()).max() > inOrder.getPrice();
		default:
			log.error("order side is invalid, clOrdId is {}", inOrder.getClOrdId());
			return false;
		}
	}

	private MutableSet<Order> selectOrder(MutableSet<Order> orderSet, int instrumentId, Side side) {
		return orderSet
				.select(order -> order.getInstrumentId() == instrumentId
						&& (order.getOrdStatus() == OrdStatus.New.code()
								|| order.getOrdStatus() == OrdStatus.PendingNew.code())
						&& order.getSide() == side.code())
				.tap(order -> log.info(
						"selected order -> instrumentId == {}, clOrdId == {}, ordStatus == {}, side =={}, price == {}",
						order.getInstrumentId(), order.getClOrdId(), order.getOrdStatus(), order.getSide(),
						order.getPrice()));
	}

	@Override
	public String getValidatorName() {
		return this.getClass().getSimpleName();
	}

}
