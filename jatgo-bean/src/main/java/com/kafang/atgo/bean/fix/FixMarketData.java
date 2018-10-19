package com.kafang.atgo.bean.fix;

import java.time.LocalDateTime;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.field.FixMarketDataField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public final class FixMarketData extends BaseFixBean<FixMarketDataField> {

	private LocalDateTime sendingTime;
	private int symbol;
	private int securityType;
	private int securityExchange;
	private LocalDateTime transactTime;
	private int tradingSessionID;
	private long totalVolumeTraded;
	private double totalAmtTraded;
	private double lastPx;
	private double highPx;
	private double lowPx;
	private double openPx;

	private double bidPrice1;
	private double bidPrice2;
	private double bidPrice3;
	private double bidPrice4;
	private double bidPrice5;
	private double askPrice1;
	private double askPrice2;
	private double askPrice3;
	private double askPrice4;
	private double askPrice5;

	private long bidVolume1;
	private long bidVolume2;
	private long bidVolume3;
	private long bidVolume4;
	private long bidVolume5;
	private long askVolume1;
	private long askVolume2;
	private long askVolume3;
	private long askVolume4;
	private long askVolume5;

	public FixMarketData(FixMessage message) throws FixMessageAnalysisException {
		super(message);
	}

	@Override
	public ImmutableList<FixMarketDataField> getFixFields() {
		return FixFieldLists.FixMarketDataFields;
	}

	@Override
	protected void setAttributes() {
//		setMsgType(getValue(FixMarketDataField.MsgType));
//		setSendingTime(getValue(FixMarketDataField.SendingTime));
//		setSymbol(getValue(FixMarketDataField.Symbol));
//		setSecurityType(getValue(FixMarketDataField.SecurityType));
//		setSecurityExchange(getValue(FixMarketDataField.SecurityExchange));
//		setTransactTime(getValue(FixMarketDataField.TransactTime));
//		setTradingSessionID(getValue(FixMarketDataField.TradingSessionID));
//		setTotalVolumeTraded(getValue(FixMarketDataField.TotalVolumeTraded));
//		setTotalAmtTraded(getValue(FixMarketDataField.TotalAmtTraded));
//		setLastPx(getValue(FixMarketDataField.LastPx));
//		setHighPx(getValue(FixMarketDataField.HighPx));
//		setLowPx(getValue(FixMarketDataField.LowPx));
//		setOpenPx(getValue(FixMarketDataField.OpenPx));
//		setBidPrice1(getValue(FixMarketDataField.))
	}

	@Override
	protected MutableMap<FixMarketDataField, Object> attributesToMap() {
		return null;
	}

}
