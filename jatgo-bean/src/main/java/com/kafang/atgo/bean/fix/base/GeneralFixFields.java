package com.kafang.atgo.bean.fix.base;

public enum GeneralFixFields implements GeneralFixField {

	// 成交均价
	FixField_AvgPx(6, "AvgPx", FixFieldType.DOUBLE),

	// 委托编号(日内唯一)
	FixField_ClOrdID(11, "ClOrdID", FixFieldType.LONG),

	// 成交数量
	FixField_CumQty(14, "CumQty", FixFieldType.INT),

	// 本回报编号(日内唯一)
	FixField_ExecID(17, "ExecID", FixFieldType.LONG),

	// 委托级别(3=Algo, 2=Uncensored, 1=Actual)
	FixField_HandlInst(21, "HandlInst", FixFieldType.INT),

	// 最新成交价
	FixField_LastPx(31, "LastPx", FixFieldType.DOUBLE),

	// 消息类型
	FixField_MsgType(35, "MsgType", FixFieldType.STRING),

	// 券商委托编号(日内唯一)
	FixField_OrderID(37, "OrderID", FixFieldType.STRING),

	// 委托股数
	FixField_OrderQty(38, "OrderQty", FixFieldType.INT),

	// 委托状态
	FixField_OrdStatus(39, "OrdStatus", FixFieldType.INT),

	// 委托类型
	FixField_OrdType(40, "OrdType", FixFieldType.INT),

	// 被撤的委托编号(日内唯一)
	FixField_OrigClOrdID(41, "OrigClOrdID", FixFieldType.STRING),

	// 委托价格
	FixField_Price(44, "Price", FixFieldType.DOUBLE),

	// 发送的北京时间
	FixField_SendingTime(52, "SendingTime", FixFieldType.DATETIME),

	// 方向(1=Buy, 2=Sell)
	FixField_Side(54, "Side", FixFieldType.INT),

	// 六位证券代码
	FixField_Symbol(55, "Symbol", FixFieldType.INT),

	// 内容
	FixField_Text(58, "Text", FixFieldType.STRING),

	// 发布的北京时间
	FixField_TransactTime(60, "TransactTime", FixFieldType.DATETIME),

	// 紧急程度
	FixField_Urgency(61, "Urgency", FixFieldType.INT),

	// 拒撤原因
	FixField_CxlRejReason(102, "CxlRejReason", FixFieldType.INT),

	// 母账户编号
	FixField_ClientID(109, "ClientID", FixFieldType.INT),

	// 对应母单委托编号
	FixField_QuoteID(117, "QuoteID", FixFieldType.LONG),

	// 撤单类型
	FixField_CxlType(125, "CxlType", FixFieldType.INT),

	// 订单终止时间
	FixField_ExpireTime(126, "ExpireTime", FixFieldType.DATETIME),

	// 昨收
	FixField_PrevClosePx(140, "PrevClosePx", FixFieldType.DOUBLE),

	// 新闻标题
	FixField_Headline(148, "Headline", FixFieldType.STRING),

	// 仍可撮合量
	FixField_LeavesQty(151, "LeavesQty", FixFieldType.INT),

	// 证券类型
	FixField_SecurityType(167, "SecurityType", FixFieldType.INT),

	// 订单生效时间
	FixField_EffectiveTime(168, "EffectiveTime", FixFieldType.DATETIME),

	// 交易所类型
	FixField_SecurityExchange(207, "SecurityExchange", FixFieldType.INT),

	// 最高价
	FixField_HighPx(332, "HighPx", FixFieldType.DOUBLE),

	// 最低价
	FixField_LowPx(333, "LowPx", FixFieldType.DOUBLE),

	// 交易阶段
	FixField_TradingSessionID(336, "TradingSessionID", FixFieldType.INT),

	// 累积成交量
	FixField_TotalVolumeTraded(387, "TotalVolumeTraded", FixFieldType.LONG),

	// 当前持仓量
	FixField_CurrentQty(1311, "CurrentQty", FixFieldType.INT),

	// 可卖量
	FixField_TradableQty(1312, "TradableQty", FixFieldType.INT),

	// 融券可借量
	FixField_ShortQty(1313, "ShortQty", FixFieldType.INT),

	// 普通买入可用金额
	FixField_EnableBalance(1321, "EnableBalance", FixFieldType.DOUBLE),

	// 信用买入可用金额
	FixField_CreditBalance(1322, "CreditBalance", FixFieldType.DOUBLE),

	// 模块状态
	FixField_ModuleStatus(1332, "ModuleStatus", FixFieldType.INT),

	// 子账户编号
	FixField_AccountID(1340, "AccountID", FixFieldType.INT),

	// 请求者的进程编号
	FixField_ProcessID(1360, "ProcessID", FixFieldType.INT),

	// 已报待成交量
	FixField_OutstandingQty(1370, "OutstandingQty", FixFieldType.INT),

	// 累积成交金额
	FixField_TotalAmtTraded(1401, "TotalAmtTraded", FixFieldType.DOUBLE),

	// 开盘价
	FixField_OpenPx(1402, "OpenPx", FixFieldType.DOUBLE),

	// 涨停价
	FixField_UpPx(1403, "UpPx", FixFieldType.DOUBLE),

	// 跌停价
	FixField_DownPx(1404, "DownPx", FixFieldType.DOUBLE),

	// 最小价格变动单位
	FixField_TickSize(1405, "TickSize", FixFieldType.DOUBLE),

	// 最小交易股数
	FixField_LotSize(1406, "LotSize", FixFieldType.INT),

	// ST标志(0=Normal, 1=ST, 2=ST*)
	FixField_SpecTreat(1407, "SpecTreat", FixFieldType.INT),

	// 涨停不卖跌停不买
	FixField_LimitAction(1410, "LimitAction", FixFieldType.INT),

	// 结束后是否继续成交
	FixField_AfterAction(1411, "AfterAction", FixFieldType.INT),

	// 5档买价
	FixField_BidPrice1(1501, "BidPrice1", FixFieldType.DOUBLE),
	FixField_BidPrice2(1502, "BidPrice2", FixFieldType.DOUBLE),
	FixField_BidPrice3(1503, "BidPrice3", FixFieldType.DOUBLE),
	FixField_BidPrice4(1504, "BidPrice4", FixFieldType.DOUBLE),
	FixField_BidPrice5(1505, "BidPrice5", FixFieldType.DOUBLE),

	// 5档卖价
	FixField_AskPrice1(1601, "AskPrice1", FixFieldType.DOUBLE),
	FixField_AskPrice2(1602, "AskPrice2", FixFieldType.DOUBLE),
	FixField_AskPrice3(1603, "AskPrice3", FixFieldType.DOUBLE),
	FixField_AskPrice4(1604, "AskPrice4", FixFieldType.DOUBLE),
	FixField_AskPrice5(1605, "AskPrice5", FixFieldType.DOUBLE),

	// 5档买量
	FixField_BidVolume1(1701, "AskPrice1", FixFieldType.LONG),
	FixField_BidVolume2(1702, "AskPrice2", FixFieldType.LONG),
	FixField_BidVolume3(1703, "AskPrice3", FixFieldType.LONG),
	FixField_BidVolume4(1704, "AskPrice4", FixFieldType.LONG),
	FixField_BidVolume5(1705, "AskPrice5", FixFieldType.LONG),

	// 5档卖量
	FixField_AskVolume1(1801, "AskVolume1", FixFieldType.LONG),
	FixField_AskVolume2(1802, "AskVolume2", FixFieldType.LONG),
	FixField_AskVolume3(1803, "AskVolume3", FixFieldType.LONG),
	FixField_AskVolume4(1804, "AskVolume4", FixFieldType.LONG),
	FixField_AskVolume5(1805, "AskVolume5", FixFieldType.LONG),

	;

	private int tag;
	private String fieldName;
	private FixFieldType type;

	private GeneralFixFields(int tag, String fieldName, FixFieldType type) {
		this.tag = tag;
		this.fieldName = fieldName;
		this.type = type;
	}

	@Override
	public int tag() {
		return tag;
	}

	@Override
	public FixFieldType type() {
		return type;
	}

	@Override
	public String fieldName() {
		return fieldName;
	}

}
