package com.kafang.atgo.risk.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewOrderFrequencyConfig {

	private int instrumentId;
	private int seconds;
	private int limitOrder;
	private int limitQty;
	private int limitAmount;

}
