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
 * 结算报表-策略
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
@Entity(name="RPT_STRATEGY")
public class RptStrategy {
	
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
		String TaskMcap="TaskMcap";
		String FilledMcap="FilledMcap";
		String OverMcap="OverMcap";
		String UnderMcap="UnderMcap";
		String CancelRatio="CancelRatio";
		String PnLLiq="PnLLiq";
		String PnLBPS="PnLBPS";
		String PnLYuan="PnLYuan";
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
	
	@Column(name = "TaskMcap", length = 200, nullable = true)
	private Double taskMcap;//母单委托总金额（算法双边，t0单边）

	@Column(name = "FilledMcap", length = 200, nullable = true)
	private Double filledMcap;//成交总金额（算法双边，t0单边）

	@Column(name = "OverMcap", length = 200, nullable = true)
	private Double overMcap;//算法类过度交易金额，t0类隔夜多头是指

	@Column(name = "UnderMcap", length = 200, nullable = true)
	private Double underMcap;//算法类未完成交易金额，t0类隔夜空头市值

	@Column(name = "CancelRatio", length = 200, nullable = true)
	private Double cancelRatio;//撤单率

	@Column(name = "PnLLiq", length = 200, nullable = true)
	private Double pnLLiq;//平昨盈亏（单位元）

	@Column(name = "PnLBPS", length = 200, nullable = true)
	private Double pnLBPS;//相对TaskMcap的收益率（单位万一）

	@Column(name = "PnLYuan", length = 200, nullable = true)
	private Double pnLYuan;//盈亏（单位元）


}
