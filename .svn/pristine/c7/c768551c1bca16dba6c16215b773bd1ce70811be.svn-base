package com.kafang.atgo.risk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafang.atgo.bean.fix.FixBalance;
import com.kafang.atgo.bean.fix.FixCancelOrder;
import com.kafang.atgo.bean.fix.FixInstrumentInfo;
import com.kafang.atgo.bean.fix.FixMarketData;
import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.bean.fix.FixPosition;
import com.kafang.atgo.bean.fix.FixStatus;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.memory.container.BalanceStorage;
import com.kafang.atgo.memory.container.MarketDataStorage;
import com.kafang.atgo.memory.container.OrderStorage;
import com.kafang.atgo.memory.container.PositionStorage;
import com.kafang.atgo.memory.container.StatusStorage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RiskModuleMessageHandler {

	@Autowired
	private BalanceStorage balanceStorage;

	@Autowired
	private MarketDataStorage marketDataStorage;
	
	@Autowired
	private OrderStorage orderStorage;
	
	@Autowired
	private PositionStorage positionStorage;
	
	@Autowired
	private StatusStorage statusStorage;

	public void onMessage(String msgString) {
		FixMessage fixMessage = new FixMessage(msgString);
		log.info("FixMessage MsgType is {}", fixMessage.getMsgType());
		switch (fixMessage.getMsgType()) {
		case MarketDataLevel1:
			FixMarketData fixMarketData = new FixMarketData(fixMessage);
			marketDataStorage.inMarketData(fixMarketData);
			break;
		case InstrumentInfo:
			FixInstrumentInfo fixInstrumentInfo = new FixInstrumentInfo(fixMessage);
			marketDataStorage.inInstrumentInfo(fixInstrumentInfo);
			break;
		case Order:
		case OrderReport:
			FixOrder fixOrder = new FixOrder(fixMessage);
			orderStorage.inFixOrder(fixOrder);
			break;
		case CancelOrder:
		case CancelOrderReport:
			FixCancelOrder fixCancelOrder = new FixCancelOrder(fixMessage);
			orderStorage.inFixCancelOrder(fixCancelOrder);
			break;
		case ReportBalance:
			FixBalance fixBalance = new FixBalance(fixMessage);
			balanceStorage.inFixBalance(fixBalance);
			break;
		case ReportPosition:
			FixPosition fixPosition = new FixPosition(fixMessage);
			positionStorage.inFixPosition(fixPosition);
			break;
		case ReportStatus:
			FixStatus fixStatus = new FixStatus(fixMessage);
			statusStorage.inFixStatus(fixStatus);
			break;
		default:
			break;
		}
	}

}
