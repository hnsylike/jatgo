package com.kafang.atgo.bean.fix;

import java.time.LocalDateTime;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.base.FixRequiredFieldMissingException;
import com.kafang.atgo.bean.fix.base.InvalidFixFieldValue;
import com.kafang.atgo.bean.fix.enums.MsgType;
import com.kafang.atgo.bean.fix.field.FixPositionField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public final class FixPosition extends BaseFixBean<FixPositionField> {

	private LocalDateTime sendingTime;
	private LocalDateTime transactTime;
	private int clientId;
	private int symbol;
	private int securityType;
	private int securityExchange;
	private int currentQty;
	private int tradableQty;
	private int shortQty;

	public FixPosition() {
		super(MsgType.ReportPosition);
	}

	public FixPosition(FixMessage message) throws FixMessageAnalysisException {
		super(message);
	}

	@Override
	public ImmutableList<FixPositionField> getFixFields() {
		return FixFieldLists.FixPositionFields;
	}

	@Override
	protected void setAttributes() {
		setSendingTime((LocalDateTime) getValue(FixPositionField.SendingTime)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixPositionField.SendingTime)));
		setTransactTime(
				(LocalDateTime) getValue(FixPositionField.TransactTime).orElse(InvalidFixFieldValue.TransactTime));
		setClientId((int) getValue(FixPositionField.ClientID)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixPositionField.ClientID)));
		setSymbol((int) getValue(FixPositionField.Symbol)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixPositionField.Symbol)));
		setSecurityType((int) getValue(FixPositionField.SecurityType)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixPositionField.SecurityType)));
		setSecurityExchange((int) getValue(FixPositionField.SecurityExchange)
				.orElseThrow(() -> new FixRequiredFieldMissingException(FixPositionField.SecurityExchange)));
		setCurrentQty((int) getValue(FixPositionField.CurrentQty).orElse(InvalidFixFieldValue.CurrentQty));
		setTradableQty((int) getValue(FixPositionField.TradableQty).orElse(InvalidFixFieldValue.TradableQty));
		setShortQty((int) getValue(FixPositionField.ShortQty).orElse(InvalidFixFieldValue.ShortQty));
	}

	@Override
	protected MutableMap<FixPositionField, Object> attributesToMap() {

		return null;
	}

}
