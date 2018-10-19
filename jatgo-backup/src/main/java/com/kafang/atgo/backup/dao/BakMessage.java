package com.kafang.atgo.backup.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "BAK_MESSAGE")
public class BakMessage {

	public interface TableColumn {
		String ID = "ID";
		String ReceivedDate = "ReceivedDate";
		String ReceivedTime = "ReceivedTime";
		String MsgType = "MsgType";
		String HandlInst = "HandlInst";
		String MsgText = "MsgText";
	}

	public static enum BakMessageMsgType {

		Heartbeat("0"), ResendRequest("2"), ResendEndFlag("EF"), InstrumentInfo("II"), MarketDataLevel1("W"),
		OrderActual("D3"), OrderUncensor("D2"), OrderAlgo("D1"), ReportAlgo("83"), ReportUncensor("82"),
		ReportActual("81"), CancelAlgo("F3"), CancelUncensor("F2"), CancelActual("F1"), ReportPosition("RP"),
		ReportStatus("RS"), ReportBalance("RB"), News("B"),;
		private String code;

		private BakMessageMsgType(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ReceivedDate", nullable = false)
	private int receivedDate;

	@Column(name = "ReceivedTime", nullable = false)
	private int receivedTime;

	@Column(name = "MsgType", length = 2, nullable = false)
	private String msgType;

	@Column(name = "HandlInst", nullable = false)
	private int handlInst;

	@Column(name = "MsgText", nullable = false, columnDefinition = "TEXT")
	private String msgText;

	public Long getId() {
		return id;
	}

	public BakMessage setId(Long id) {
		this.id = id;
		return this;
	}

	public int getReceivedDate() {
		return receivedDate;
	}

	public BakMessage setReceivedDate(int receivedDate) {
		this.receivedDate = receivedDate;
		return this;
	}

	public int getReceivedTime() {
		return receivedTime;
	}

	public BakMessage setReceivedTime(int receivedTime) {
		this.receivedTime = receivedTime;
		return this;
	}

	public String getMsgType() {
		return msgType;
	}

	public BakMessage setMsgType(String msgType) {
		this.msgType = msgType;
		return this;
	}

	public int getHandlInst() {
		return handlInst;
	}

	public BakMessage setHandlInst(int handlInst) {
		this.handlInst = handlInst;
		return this;
	}

	public String getMsgText() {
		return msgText;
	}

	public BakMessage setMsgText(String msgText) {
		this.msgText = msgText;
		return this;
	}

}
