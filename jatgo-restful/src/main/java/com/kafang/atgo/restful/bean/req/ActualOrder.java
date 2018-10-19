package com.kafang.atgo.restful.bean.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActualOrder {
	private int ClientID;
	private String Symbol;
	private int Side;
	private int OrderQty;
	private String OrdType;
	private Double Price;
}
