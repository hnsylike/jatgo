package com.kafang.atgo.bean.fix;

import java.time.LocalDateTime;

import com.kafang.atgo.bean.fix.enums.AfterAction;
import com.kafang.atgo.bean.fix.enums.HandlInst;
import com.kafang.atgo.bean.fix.enums.LimitAction;
import com.kafang.atgo.bean.fix.enums.MsgType;
import com.kafang.atgo.bean.fix.enums.OrdStatus;
import com.kafang.atgo.bean.fix.enums.OrdType;
import com.kafang.atgo.bean.fix.enums.SecurityExchange;
import com.kafang.atgo.bean.fix.enums.SecurityType;
import com.kafang.atgo.bean.fix.enums.Side;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.BizOrder;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.base.FixRequiredFieldMissingException;
import com.kafang.atgo.bean.fix.base.InvalidFixFieldValue;
import com.kafang.atgo.bean.fix.field.FixOrderField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public final class FixOrder extends BaseFixBean<FixOrderField> implements Comparable<FixOrder>, BizOrder {

	private LocalDateTime sendingTime;
	private long clOrdId;
	private int clientId;
	private int accountId;
	private int handlInst;
	private long quoteId;
	private int symbol;
	private int securityType;
	private int securityExchange;
	private int side;
	private LocalDateTime transactTime;
	private int orderQty;
	private int ordType;
	private double price;
	private LocalDateTime effectiveTime;
	private LocalDateTime expireTime;
	private long execId;
	private String orderId;
	private int cumQty;
	private int leavesQty;
	private int outstandingQty;
	private double avgPx;
	private int ordStatus;
	private int limitAction;
	private int afterAction;
	private String text;

	private FixOrder(MsgType msgType) {
		super(msgType);
	}

	public FixOrder(FixMessage message) throws FixMessageAnalysisException {
		super(message);
	}

	public static FixOrder buildFixOrder() {
		return new FixOrder(MsgType.Order);
	}

	public static FixOrder buildFixOrderReport() {
		return new FixOrder(MsgType.OrderReport);
	}

	/**
	 * OrderSet 唯一性识别, 当Symbol, Price, Qty, SendingTime都相同时, 判断为同一个订单.
	 * <p>
	 * Set排序算法.
	 */
	@Override
	public int compareTo(FixOrder o) {
		return this.clOrdId < o.clOrdId ? -1 : this.clOrdId > o.clOrdId ? 1 : 0;
	}

	@Override
	public ImmutableList<FixOrderField> getFixFields() {
		return FixFieldLists.FixOrderFields;
	}

	@Override
	protected void setAttributes() {
		setSendingTime((LocalDateTime) getValue(FixOrderField.SendingTime)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixOrderField.SendingTime)));
		setClOrdId((long) getValue(FixOrderField.ClOrdID).orElse(InvalidFixFieldValue.ClOrdID));
		setClientId((int) getValue(FixOrderField.ClientID).orElse(InvalidFixFieldValue.ClientID));
		setAccountId((int) getValue(FixOrderField.AccountID).orElse(InvalidFixFieldValue.AccountID));
		setHandlInst((int) getValue(FixOrderField.HandlInst).orElse(HandlInst.Invalid.code()));
		setQuoteId((long) getValue(FixOrderField.QuoteID).orElse(InvalidFixFieldValue.QuoteID));
		setSymbol((int) getValue(FixOrderField.Symbol)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixOrderField.Symbol)));
		setSecurityType((int) getValue(FixOrderField.SecurityType).orElse(SecurityType.Invalid.code()));
		setSecurityExchange((int) getValue(FixOrderField.SecurityExchange).orElse(SecurityExchange.Invalid.code()));
		setSide((int) getValue(FixOrderField.Side).orElse(Side.Invalid.code()));
		setTransactTime((LocalDateTime) getValue(FixOrderField.TransactTime).orElse(InvalidFixFieldValue.TransactTime));
		setOrderQty((int) getValue(FixOrderField.OrderQty)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixOrderField.OrderQty)));
		setOrdType((int) getValue(FixOrderField.OrdType).orElse(OrdType.Invalid.code()));
		setPrice((double) getValue(FixOrderField.Price).orElse(InvalidFixFieldValue.Price));
		setEffectiveTime(
				(LocalDateTime) getValue(FixOrderField.EffectiveTime).orElse(InvalidFixFieldValue.EffectiveTime));
		setExpireTime((LocalDateTime) getValue(FixOrderField.ExpireTime).orElse(InvalidFixFieldValue.ExpireTime));
		setExecId((long) getValue(FixOrderField.ExecID).orElse(InvalidFixFieldValue.ExecID));
		setOrderId((String) getValue(FixOrderField.OrderID).orElse(InvalidFixFieldValue.OrderID));
		setCumQty((int) getValue(FixOrderField.CumQty).orElse(InvalidFixFieldValue.CumQty));
		setLeavesQty((int) getValue(FixOrderField.LeavesQty).orElse(InvalidFixFieldValue.LeavesQty));
		setOutstandingQty((int) getValue(FixOrderField.OutstandingQty).orElse(InvalidFixFieldValue.OutstandingQty));
		setAvgPx((double) getValue(FixOrderField.AvgPx).orElse(InvalidFixFieldValue.AvgPx));
		setOrdStatus((int) getValue(FixOrderField.OrdStatus).orElse(OrdStatus.Invalid.code()));
		setLimitAction((int) getValue(FixOrderField.LimitAction).orElse(LimitAction.Invalid.code()));
		setAfterAction((int) getValue(FixOrderField.AfterAction).orElse(AfterAction.Invalid.code()));
		setText((String) getValue(FixOrderField.Text).orElse(InvalidFixFieldValue.Text));
	}

	@Override
	protected MutableMap<FixOrderField, Object> attributesToMap() {
		MutableMap<FixOrderField, Object> map = newMap();
		map.put(FixOrderField.SendingTime, getSendingTime());
		map.put(FixOrderField.ClOrdID, getClOrdId());
		map.put(FixOrderField.ClientID, getClientId());
		map.put(FixOrderField.AccountID, getAccountId());
		map.put(FixOrderField.HandlInst, getHandlInst());
		map.put(FixOrderField.QuoteID, getQuoteId());
		map.put(FixOrderField.Symbol, getSymbol());
		map.put(FixOrderField.SecurityType, getSecurityType());
		map.put(FixOrderField.SecurityExchange, getSecurityExchange());
		map.put(FixOrderField.Side, getSide());
		map.put(FixOrderField.TransactTime, getTransactTime());
		map.put(FixOrderField.OrderQty, getOrderQty());
		map.put(FixOrderField.OrdType, getOrdType());
		map.put(FixOrderField.Price, getPrice());
		map.put(FixOrderField.EffectiveTime, getEffectiveTime());
		map.put(FixOrderField.ExpireTime, getExpireTime());
		map.put(FixOrderField.ExecID, getExecId());
		map.put(FixOrderField.OrderID, getOrderId());
		map.put(FixOrderField.CumQty, getCumQty());
		map.put(FixOrderField.LeavesQty, getLeavesQty());
		map.put(FixOrderField.OutstandingQty, getOutstandingQty());
		map.put(FixOrderField.AvgPx, getAvgPx());
		map.put(FixOrderField.OrdStatus, getOrdStatus());
		map.put(FixOrderField.LimitAction, getLimitAction());
		map.put(FixOrderField.AfterAction, getAfterAction());
		map.put(FixOrderField.Text, getText());
		return map;
	}

}
