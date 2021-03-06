package com.kafang.atgo.restful.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Entity(name = "MSGD_ORDER_ALGO")
public class MsgdOrderAlgo {
	
	public interface TableColumn {
		String ClOrdID = "clOrdID";
		String ClientID = "clientID";
		String Account = "account";
		String Symbol = "symbol";
		String SecurityType = "securityType";
		String SecurityExchange = "securityExchange";
		String Side = "side";
		String TransactTime = "transactTime";
		String OrderQty = "orderQty";
		String OrdType = "ordType";
		String Price = "price";
		String EffectiveTime = "effectiveTime";
		String ExpireTime = "expireTime";
		String LimitAction = "limitAction";
		String AfterAction = "afterAction";
		String Text = "text";
	}

	@Column(name = "ClOrdID", length = 50, nullable = true)
	private String clOrdId;

	@Column(name = "ClientID", length = 11, nullable = true)
	private Long clientId;

	@Column(name = "Account", length = 10, nullable = true)
	private String account;

	@Column(name = "Symbol", length = 11, nullable = true)
	private Long symbol;

	@Column(name = "SecurityType", length = 11, nullable = true)
	private Long securityType;

	@Column(name = "SecurityExchange", length = 11, nullable = true)
	private Long securityExchange;

	@Column(name = "Side", length = 11, nullable = true)
	private Long side;

	@Column(name = "TransactTime", nullable = true)
	private Date transactTime;

	@Column(name = "OrderQty", length = 11, nullable = true)
	private Long orderQty;

	@Column(name = "OrdType", length = 11, nullable = true)
	private Long ordType;

	@Column(name = "Price", nullable = true)
	private Long price;

	@Column(name = "EffectiveTime", nullable = true)
	private Date effectiveTime;

	@Column(name = "ExpireTime", nullable = true)
	private Date expireTime;

	@Column(name = "LimitAction", length = 11, nullable = true)
	private Long limitAction;

	@Column(name = "AfterAction", length = 11, nullable = true)
	private Long afterAction;

	@Column(name = "Text", length = 200, nullable = true)
	private String text;


}
