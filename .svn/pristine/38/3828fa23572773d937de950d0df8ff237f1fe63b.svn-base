package com.kafang.atgo.restful.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 结算报表-母单
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
@Entity(name="RPT_NOMINAL")
public class RptNominal {
	
	public interface TableColumn {
		String ID="ID";
		String AsOfDate="AsOfDate";
		String CustomerID="CustomerID";
		String CustomerName="CustomerName";
		String ClientID="ClientID";
		String ClientName="ClientName";
		String StrategyID="StrategyID";
		String StrategyName="StrategyName";
		String AccountID="AccountID";
		String QuoteID="QuoteID";
		String Symbol="Symbol";
		String SecurityType="SecurityType";
		String SecurityExchange="SecurityExchange";
		String StartTime="StartTime";
		String EndTime="EndTime";
		String DeliverTime="DeliverTime";
		String CancelTime="CancelTime";
		String TaskQty="TaskQty";
		String CancelQty="CancelQty";
		String BenchmarkType="BenchmarkType";
		String TWAP="TWAP";
		String VWAP="VWAP";
		String ArrivalPrice="ArrivalPrice";
		String ClosePrice="ClosePrice";
		String FilledQtyAgg="FilledQtyAgg";
		String DifQtyAgg="DifQtyAgg";
		String FilledPriceAgg="FilledPriceAgg";
		String OrderCountAgg="OrderCountAgg";
		String CanceledCountAgg="CanceledCountAgg";
		String FeeAgg="FeeAgg";
		String intMarketStatus="intMarketStatus";
	}
	
	@Id
	@Column(name="ID")			
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "AsOfDate", nullable = true)
	private Date  asOfDate;//日期

	@Column(name = "CustomerID", length = 200, nullable = true)
	private int customerId;//客户编号
		
	@Column(name = "CustomerName", length = 255, nullable = true)
	private String customerName;//客户名称

	@Column(name = "ClientID", length = 200, nullable = true)
	private int clientId;//母账户编号
		
	@Column(name = "ClientName", length = 255, nullable = true)
	private String clientName;//母账户名称
	
	@Column(name = "StrategyID", length = 100, nullable = true)
	private int strategyId;//策略编号

	@Column(name = "StrategyName", length = 255, nullable = true)
	private String strategyName;//策略名称
		
	@Column(name = "AccountID", length = 200, nullable = true)
	private int accountId;//子账户编号

	@Column(name = "QuoteID", length = 200, nullable = true)
	private String quoteId;//对应母单委托编号
		

	@Column(name = "Symbol", length = 50, nullable = true)
	private int symbol;//六位证券代码

	@Column(name = "SecurityType", length = 200, nullable = true)
	private String securityType;//证券类型

	@Column(name = "SecurityExchange", length = 200, nullable = true)
	private String securityExchange;//交易所类型
	
	@Column(name = "StartTime", nullable = true)
	private Date startTime;//母单生效的北京时间
	
	@Column(name = "EndTime", nullable = true)
	private Date endTime;//母单结束的北京时间

	@Column(name = "DeliverTime", nullable = true)
	private Date deliverTime;//母单提交的北京时间

	@Column(name = "CancelTime", nullable = true)
	private Date cancelTime;//母单撤销的北京时间

	@Column(name = "TaskQty",length = 200,  nullable = true)
	private int taskQty;//母单委托股数 (正买负卖)

	@Column(name = "CancelQty", length = 200, nullable = true)
	private int cancelQty;//母单撤销股数 (正买负卖)

	@Column(name = "BenchmarkType",length = 200,  nullable = true)
	private String benchmarkType;//母单类型

	@Column(name = "TWAP", length = 200,nullable = true)
	private Double tWAP;//TWAP

	@Column(name = "VWAP",length = 200, nullable = true)
	private Double vWAP;//VWAP

	@Column(name = "ArrivalPrice", length = 200,nullable = true)
	private Double arrivalPrice;//Mid-price of max(DeliverTime, StartTime)

	@Column(name = "ClosePrice",length = 200, nullable = true)
	private Double closePrice;//Last-price of min(EndTime, CanceledTime)

	@Column(name = "FilledQtyAgg",length = 200, nullable = true)
	private int filledQtyAgg;//汇总成交数量 (正买负卖)

	@Column(name = "DifQtyAgg",length = 200, nullable = true)
	private int difQtyAgg;//汇总差额 (算法正过度负未完，t0正隔夜多负空)

	@Column(name = "FilledPriceAgg",length = 200, nullable = true)
	private Double filledPriceAgg;//汇总成交价格

	@Column(name = "OrderCountAgg",length = 200, nullable = true)
	private int orderCountAgg;//子单笔数

	@Column(name = "CanceledCountAgg",length = 200, nullable = true)
	private int canceledCountAgg;//子单撤单笔数

	@Column(name = "FeeAgg", length = 200,nullable = true)
	private Double feeAgg;//手续费

	@Column(name = "MarketStatus",length = 200, nullable = true)
	private int marketStatus;//市场状态


}
