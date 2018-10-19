package com.kafang.atgo.memory.container;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.springframework.stereotype.Component;

import com.kafang.atgo.bean.fix.FixInstrumentInfo;
import com.kafang.atgo.bean.fix.FixMarketData;
import com.kafang.atgo.memory.avro.record.InstrumentInfo;
import com.kafang.atgo.memory.avro.record.MarketData;
import com.kafang.atgo.memory.avro.record.MdEntry;
import com.kafang.atgo.memory.utils.InstrumentIdHelper;

import io.ffreedom.common.datetime.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MarketDataStorage {

	//public static final MarketDataStorage INSTANCE = new MarketDataStorage();

	// instrumentId -> MarketData
	private MutableIntObjectMap<MarketData> marketDataMap = new IntObjectHashMap<>();

	// instrumentId -> InstrumentInfo
	private MutableIntObjectMap<InstrumentInfo> instrumentInfoMap = new IntObjectHashMap<>();

	@PostConstruct
	private void init() {
		log.info("MarketDataStorage initialized...");
	}
	
	public void inMarketData(FixMarketData fixMarketData) {
		int instrumentId = InstrumentIdHelper.getInstrumentId(fixMarketData.getSecurityExchange(),
				fixMarketData.getSymbol());
		if (marketDataMap.containsKey(instrumentId)) {
			updateMarketData(instrumentId, fixMarketData);
		} else {
			createMarketData(instrumentId, fixMarketData);
		}
	}

	public void inInstrumentInfo(FixInstrumentInfo fixInstrumentInfo) {
		int instrumentId = InstrumentIdHelper.getInstrumentId(fixInstrumentInfo.getSecurityExchange(),
				fixInstrumentInfo.getSymbol());
		instrumentInfoMap.put(instrumentId, InstrumentInfo.newBuilder().setInstrumentId(instrumentId)
				.setPrevClosePrice(fixInstrumentInfo.getPrevClosePx()).setUpPrice(fixInstrumentInfo.getUpPx())
				.setDownPrice(fixInstrumentInfo.getDownPx()).setTickSize(fixInstrumentInfo.getTickSize())
				.setLotSize(fixInstrumentInfo.getLotSize()).setSpecTreat(fixInstrumentInfo.getSpecTreat())
				.setTransactTime(DateTimeUtil.datetimeToMillisecond(fixInstrumentInfo.getTransactTime()))
				.setSendingTime(DateTimeUtil.datetimeToMillisecond(fixInstrumentInfo.getSendingTime())).build());
	}

	private void createMarketData(int instrumentID, FixMarketData fixMarketData) {
		marketDataMap.put(instrumentID,
				MarketData.newBuilder().setInstrumentId(instrumentID).setOpenPrice(fixMarketData.getOpenPx())
						.setHighPrice(fixMarketData.getHighPx()).setLowPrice(fixMarketData.getLowPx())
						.setLastPrice(fixMarketData.getLastPx())
						.setTotalVolumeTraded(fixMarketData.getTotalVolumeTraded())
						.setTotalAmtTraded(fixMarketData.getTotalAmtTraded())
						.setTradingSessionId(fixMarketData.getTradingSessionID())
						.setSendingTime(DateTimeUtil.datetimeToMillisecond(fixMarketData.getSendingTime()))
						.setTransactTime(DateTimeUtil.datetimeToMillisecond(fixMarketData.getTransactTime()))
						// set ask1-ask5
						.setAsk1(MdEntry.newBuilder().setLevel(1).setPrice(fixMarketData.getAskPrice1())
								.setVolume(fixMarketData.getAskVolume1()).build())
						.setAsk2(MdEntry.newBuilder().setLevel(2).setPrice(fixMarketData.getAskPrice1())
								.setVolume(fixMarketData.getAskVolume1()).build())
						.setAsk3(MdEntry.newBuilder().setLevel(3).setPrice(fixMarketData.getAskPrice1())
								.setVolume(fixMarketData.getAskVolume1()).build())
						.setAsk4(MdEntry.newBuilder().setLevel(4).setPrice(fixMarketData.getAskPrice1())
								.setVolume(fixMarketData.getAskVolume1()).build())
						.setAsk5(MdEntry.newBuilder().setLevel(5).setPrice(fixMarketData.getAskPrice1())
								.setVolume(fixMarketData.getAskVolume1()).build())
						// set bid1-bid5
						.setBid1(MdEntry.newBuilder().setLevel(1).setPrice(fixMarketData.getBidPrice1())
								.setVolume(fixMarketData.getBidVolume1()).build())
						.setBid2(MdEntry.newBuilder().setLevel(2).setPrice(fixMarketData.getBidPrice1())
								.setVolume(fixMarketData.getBidVolume1()).build())
						.setBid3(MdEntry.newBuilder().setLevel(3).setPrice(fixMarketData.getBidPrice1())
								.setVolume(fixMarketData.getBidVolume1()).build())
						.setBid4(MdEntry.newBuilder().setLevel(4).setPrice(fixMarketData.getBidPrice1())
								.setVolume(fixMarketData.getBidVolume1()).build())
						.setBid5(MdEntry.newBuilder().setLevel(5).setPrice(fixMarketData.getBidPrice1())
								.setVolume(fixMarketData.getBidVolume1()).build())
						.build());
	}

	private void updateMarketData(int instrumentID, FixMarketData fixMarketData) {
		MarketData marketData = marketDataMap.get(instrumentID);
		marketData.setHighPrice(fixMarketData.getHighPx()).setLowPrice(fixMarketData.getLowPx())
				.setLastPrice(fixMarketData.getLastPx()).setTotalVolumeTraded(fixMarketData.getTotalVolumeTraded())
				.setTotalAmtTraded(fixMarketData.getTotalAmtTraded())
				.setTradingSessionId(fixMarketData.getTradingSessionID())
				.setSendingTime(DateTimeUtil.datetimeToMillisecond(fixMarketData.getSendingTime()))
				.setTransactTime(DateTimeUtil.datetimeToMillisecond(fixMarketData.getTransactTime()));
		marketData.getAsk1().setPrice(fixMarketData.getAskPrice1()).setVolume(fixMarketData.getAskVolume1());
		marketData.getAsk2().setPrice(fixMarketData.getAskPrice2()).setVolume(fixMarketData.getAskVolume2());
		marketData.getAsk3().setPrice(fixMarketData.getAskPrice3()).setVolume(fixMarketData.getAskVolume3());
		marketData.getAsk4().setPrice(fixMarketData.getAskPrice4()).setVolume(fixMarketData.getAskVolume4());
		marketData.getAsk5().setPrice(fixMarketData.getAskPrice5()).setVolume(fixMarketData.getAskVolume5());
		marketData.getBid1().setPrice(fixMarketData.getBidPrice1()).setVolume(fixMarketData.getBidVolume1());
		marketData.getBid2().setPrice(fixMarketData.getBidPrice2()).setVolume(fixMarketData.getBidVolume2());
		marketData.getBid3().setPrice(fixMarketData.getBidPrice3()).setVolume(fixMarketData.getBidVolume3());
		marketData.getBid4().setPrice(fixMarketData.getBidPrice4()).setVolume(fixMarketData.getBidVolume4());
		marketData.getBid5().setPrice(fixMarketData.getBidPrice5()).setVolume(fixMarketData.getBidVolume5());
	}

	public Optional<MarketData> getMarketData(int instrumentId) {
		if (marketDataMap.containsKey(instrumentId)) {
			return Optional.of(marketDataMap.get(instrumentId));
		}
		return Optional.empty();
	}

	public Optional<InstrumentInfo> getInstrumentInfo(int instrumentId) {
		if (instrumentInfoMap.containsKey(instrumentId)) {
			return Optional.of(instrumentInfoMap.get(instrumentId));
		}
		return Optional.empty();
	}

}
