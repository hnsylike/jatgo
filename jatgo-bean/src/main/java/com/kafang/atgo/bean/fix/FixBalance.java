package com.kafang.atgo.bean.fix;

import com.kafang.atgo.bean.fix.base.*;
import com.kafang.atgo.bean.fix.enums.MsgType;
import com.kafang.atgo.bean.fix.field.FixBalanceField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public final class FixBalance extends BaseFixBean<FixBalanceField> {

	private LocalDateTime sendingTime;
	private int clientId;
	private LocalDateTime transactTime;
	private double enableBalance;
	private double creditBalance;

	public FixBalance() {
		super(MsgType.ReportBalance);
	}

	public FixBalance(FixMessage message) throws FixMessageAnalysisException {
		super(message);
	}

	@Override
	public ImmutableList<FixBalanceField> getFixFields() {
		return FixFieldLists.FixBalanceFields;
	}

	@Override
	protected void setAttributes() {
		setSendingTime((LocalDateTime) getValue(FixBalanceField.SendingTime)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixBalanceField.SendingTime)));
		setClientId((int) getValue(FixBalanceField.ClientID)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixBalanceField.ClientID)));
		setTransactTime(
				(LocalDateTime) getValue(FixBalanceField.TransactTime).orElse(InvalidFixFieldValue.TransactTime));
		setEnableBalance((double) getValue(FixBalanceField.EnableBalance).orElse(InvalidFixFieldValue.EnableBalance));
		setCreditBalance((double) getValue(FixBalanceField.CreditBalance).orElse(InvalidFixFieldValue.CreditBalance));
	}

	@Override
	protected MutableMap<FixBalanceField, Object> attributesToMap() {
		MutableMap<FixBalanceField, Object> map = newMap();
		map.put(FixBalanceField.SendingTime, getSendingTime());
		map.put(FixBalanceField.ClientID, getClientId());
		map.put(FixBalanceField.TransactTime, getTransactTime());
		map.put(FixBalanceField.EnableBalance, getEnableBalance());
		map.put(FixBalanceField.CreditBalance, getCreditBalance());
		return map;
	}

	public static void main(String[] args) {
		FixOrder fixOrder =	FixOrder.buildFixOrder();
		fixOrder.setSecurityType(1);
		fixOrder.setSecurityExchange(1);
		fixOrder.setOrdType(1);
		fixOrder.setSide(1);
		fixOrder.setClientId(100060);
		fixOrder.setClOrdId(6);
		fixOrder.setHandlInst(1);
		fixOrder.setOrderQty(1);
		fixOrder.setPrice(1.1);
		fixOrder.setSendingTime(LocalDateTime.now());
		fixOrder.setSymbol(1);
		fixOrder.setTransactTime(LocalDateTime.now());
		fixOrder.setAccountId(1);
		fixOrder.setAfterAction(1);
		fixOrder.setEffectiveTime(LocalDateTime.now());
		fixOrder.setExpireTime(LocalDateTime.now());
		fixOrder.setLimitAction(1);
		fixOrder.setAvgPx(0);
		fixOrder.setCumQty(0);
		fixOrder.setExecId(0);
		fixOrder.setOrderId(null);
		fixOrder.setLeavesQty(0);
		fixOrder.setOrdStatus(1);
		fixOrder.setQuoteId(1);
		fixOrder.setText("test");
		System.out.println(fixOrder.toFixMessage());
	}
}
