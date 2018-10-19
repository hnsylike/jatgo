package com.kafang.atgo.backup.resend;

import com.kafang.atgo.bean.fix.enums.HandlInst;
import com.kafang.atgo.bean.fix.enums.MsgType;

public enum ResendMessage {

	Heartbeat(MsgType.Heartbeat.code(), HandlInst.Invalid.code()),

	InstrumentInfo(MsgType.InstrumentInfo.code(), HandlInst.Invalid.code()),

	MarketDataLevel1(MsgType.MarketDataLevel1.code(), HandlInst.Invalid.code()),

	News(MsgType.News.code(), HandlInst.Invalid.code()),

	ReportPosition(MsgType.ReportPosition.code(), HandlInst.Invalid.code()),

	ReportStatus(MsgType.ReportStatus.code(), HandlInst.Invalid.code()),

	ReportBalance(MsgType.ReportBalance.code(), HandlInst.Invalid.code()),

	OrderActual(MsgType.Order.code(), HandlInst.Actual.code()),

	OrderUncensor(MsgType.Order.code(), HandlInst.Uncensored.code()),

	OrderAlgo(MsgType.Order.code(), HandlInst.Algo.code()),

	ReportActual(MsgType.OrderReport.code(), HandlInst.Actual.code()),

	ReportUncensor(MsgType.OrderReport.code(), HandlInst.Invalid.code()),

	ReportAlgo(MsgType.OrderReport.code(), HandlInst.Algo.code()),

	CancelActual(MsgType.CancelOrder.code(), HandlInst.Actual.code()),

	CancelUncensor(MsgType.CancelOrder.code(), HandlInst.Uncensored.code()),

	CancelAlgo(MsgType.CancelOrder.code(), HandlInst.Algo.code()),

	;

	private String msgType;
	private int handlInst;

	private ResendMessage(String msgType, int handlInst) {
		this.msgType = msgType;
		this.handlInst = handlInst;
	}

	public String getMsgType() {
		return msgType;
	}

	public int getHandlInst() {
		return handlInst;
	}

}
