package com.kafang.atgo.restful.entity;

import com.kafang.atgo.persistence.db.base.entity.SimpleEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity(name = "WS_ORDER_INS")
public class WsOrderIns implements SimpleEntity{
	
	public interface TableColumn {
		String id = "id";
		String isReview = "isReview";
		String EffectiveTime = "EffectiveTime";
		String ExpireTime="ExpireTime";
		String limitAction="limitAction";
		String afterAction="afterAction";
		String ClOrdID="ClOrdID";
		String ClientID="ClientID";
		String AccountID="AccountID";
		String Symbol="Symbol";
		String SecurityType="SecurityType";
		String SecurityExchange="SecurityExchange";
		String Side="Side";
		String TransactTime="TransactTime";
		String OrderQty="OrderQty";
		String OrdType = "OrdType";
		String Price = "Price";
		String Text = "Text";
		String reviewTime="reviewTime";
	}

	
	private String OrderType;
	
	private int userid;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "isReview", length = 50, nullable = true)
	private int isReview;
	
	@Column(name = "reviewTime", nullable = true)
	private Date reviewTime;
	
	@Column(name = "EffectiveTime",  nullable = true)
	private Date effectiveTime;
	
	@Column(name = "ExpireTime",  nullable = true)
	private Date expireTime;
	
	@Column(name = "limitAction", length = 255, nullable = true)
	private int limitAction;
	
	@Column(name = "afterAction", length = 255, nullable = true)
	private int afterAction;
	
	@Column(name = "ClOrdID", length = 255, nullable = true)
	private Long clOrdId;
	
	@Column(name = "ClientID", length = 255, nullable = true)
	private int clientId;
	
	@Column(name = "AccountID", length = 10, nullable = true)
	private int accountId;
	
	@Column(name = "Symbol", length = 11, nullable = true)
	private String symbol;
	
	@Column(name = "SecurityType", length = 255, nullable = true)
	private int securityType;
	
	@Column(name = "SecurityExchange", length = 255, nullable = true)
	private int securityExchange;
	
	@Column(name = "Side", length = 11, nullable = true)
	private int side;
	
	@Column(name = "TransactTime", nullable = true)
	private Date transactTime;
	
	@Column(name = "OrderQty", length = 11, nullable = true)
	private int orderQty;
	
	@Column(name = "OrdType", length = 11, nullable = true)
	private String ordType;
	
	@Column(name = "Price",  nullable = true)
	private Double price;

}
