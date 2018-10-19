package com.kafang.atgo.bean.fix;

import java.time.LocalDateTime;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.field.FixInstrumentInfoField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class FixInstrumentInfo extends BaseFixBean<FixInstrumentInfoField> {

	private LocalDateTime sendingTime;
	private int symbol;
	private int securityType;
	private int securityExchange;
	private LocalDateTime transactTime;
	private double prevClosePx;
	private double upPx;
	private double downPx;
	private double tickSize;
	private int lotSize;
	private int specTreat;

	public FixInstrumentInfo(FixMessage fixMessage) throws FixMessageAnalysisException {
		super(fixMessage);
	}

	@Override
	public ImmutableList<FixInstrumentInfoField> getFixFields() {
		return FixFieldLists.FixInstrumentInfoFields;
	}

	@Override
	protected void setAttributes() {
		
	}

	@Override
	protected MutableMap<FixInstrumentInfoField, Object> attributesToMap() {

		return null;
	}
}
