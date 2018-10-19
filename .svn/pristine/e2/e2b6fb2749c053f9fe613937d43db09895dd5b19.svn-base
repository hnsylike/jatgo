package com.kafang.atgo.risk.validators;

import org.springframework.beans.factory.annotation.Value;

import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.memory.utils.InstrumentIdHelper;
import com.kafang.atgo.risk.base.BaseRiskValidator;

import io.ffreedom.common.utils.DoubleUtil;

public class NewOrderPriceValidator extends BaseRiskValidator<FixOrder> {

	@Value("${risk.price.DeviationPercent}")
	private double priceDeviationPercent;

	@Override
	public boolean validationOrder(FixOrder inOrder) {
		int instrumentId = InstrumentIdHelper.getInstrumentId(inOrder.getSecurityExchange(), inOrder.getSymbol());
		return marketDataStorage.getMarketData(instrumentId)
				// 检查价格是否偏离限定百分比
				.map(marketData -> 
					Math.abs(DoubleUtil.subtraction(inOrder.getPrice(), marketData.getLastPrice())) 
						< Math.abs(DoubleUtil.multiply8(marketData.getLastPrice(), priceDeviationPercent)))
				.orElse(false)
				&& marketDataStorage.getInstrumentInfo(instrumentId)
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
