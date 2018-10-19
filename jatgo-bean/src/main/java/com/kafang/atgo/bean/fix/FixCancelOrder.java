package com.kafang.atgo.bean.fix;

import java.time.LocalDateTime;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.BizOrder;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.base.FixRequiredFieldMissingException;
import com.kafang.atgo.bean.fix.base.InvalidFixFieldValue;
import com.kafang.atgo.bean.fix.enums.CxlRejReason;
import com.kafang.atgo.bean.fix.enums.HandlInst;
import com.kafang.atgo.bean.fix.enums.MsgType;
import com.kafang.atgo.bean.fix.enums.OrdStatus;
import com.kafang.atgo.bean.fix.field.FixCancelOrderField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public final class FixCancelOrder extends BaseFixBean<FixCancelOrderField> implements BizOrder {

	private int handlInst;
	private LocalDateTime sendingTime;
	private long origClOrdId;
	private String orderId;
	private long clOrdId;
	private int accountId;
	private int clientId;
	private LocalDateTime transactTime;
	private int cxlType;
	private int ordStatus;
	private int cxlRejReason;

	private FixCancelOrder(MsgType msgType) {
		super(msgType);
	}

	public FixCancelOrder(FixMessage message) throws FixMessageAnalysisException {
		super(message);
	}

	public static FixCancelOrder buildFixCancelOrder() {
		return new FixCancelOrder(MsgType.CancelOrder);
	}

	public static FixCancelOrder buildFixCancelOrderReport() {
		return new FixCancelOrder(MsgType.CancelOrderReport);
	}

	@Override
	public ImmutableList<FixCancelOrderField> getFixFields() {
		return FixFieldLists.FixCancelOrderFields;
	}

	@Override
	protected void setAttributes() {
		setHandlInst((int) getValue(FixCancelOrderField.HandlInst).orElse(HandlInst.Invalid.code()));
		setSendingTime((LocalDateTime) getValue(FixCancelOrderField.SendingTime)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixCancelOrderField.SendingTime)));
		setOrigClOrdId((int) getValue(FixCancelOrderField.OrigClOrdID)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixCancelOrderField.OrigClOrdID)));
		setOrderId((String) getValue(FixCancelOrderField.OrderID).orElse(InvalidFixFieldValue.OrderID));
		setClOrdId((int) getValue(FixCancelOrderField.ClOrdID).orElse(InvalidFixFieldValue.ClOrdID));
		setAccountId((int) getValue(FixCancelOrderField.AccountID).orElse(InvalidFixFieldValue.AccountID));
		setClientId((int) getValue(FixCancelOrderField.ClientID).orElse(InvalidFixFieldValue.ClientID));
		setTransactTime(
				(LocalDateTime) getValue(FixCancelOrderField.TransactTime).orElse(InvalidFixFieldValue.TransactTime));
		setOrdStatus((int) getValue(FixCancelOrderField.OrdStatus).orElse(OrdStatus.Invalid.code()));
		setCxlRejReason((int) getValue(FixCancelOrderField.CxlRejReason).orElse(CxlRejReason.Invalid.code()));
	}

	@Override
	protected MutableMap<FixCancelOrderField, Object> attributesToMap() {
		MutableMap<FixCancelOrderField, Object> map = newMap();
		map.put(FixCancelOrderField.SendingTime, getSendingTime());
		map.put(FixCancelOrderField.TransactTime, getTransactTime());
		map.put(FixCancelOrderField.HandlInst, getHandlInst());
		map.put(FixCancelOrderField.OrigClOrdID, getOrigClOrdId());
		map.put(FixCancelOrderField.OrderID, getOrderId());
		map.put(FixCancelOrderField.ClOrdID, getClOrdId());
		map.put(FixCancelOrderField.AccountID, getAccountId());
		map.put(FixCancelOrderField.ClientID, getClientId());
		map.put(FixCancelOrderField.OrdStatus, getOrdStatus());
		map.put(FixCancelOrderField.CxlRejReason, getCxlRejReason());
		return map;
	}

}
