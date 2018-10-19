package com.kafang.atgo.memory.container;

import javax.annotation.PostConstruct;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableLongIntMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.bean.fix.FixPosition;
import com.kafang.atgo.bean.fix.enums.OrdStatus;
import com.kafang.atgo.bean.fix.enums.Side;
import com.kafang.atgo.memory.avro.record.Position;
import com.kafang.atgo.memory.manager.AccountManager;
import com.kafang.atgo.memory.utils.InstrumentIdHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PositionStorage {

	// public static final PositionStorage INSTANCE = new PositionStorage();

	@Autowired
	private AccountManager accountManager;

	// Map<ClientId, Map<InstrumentId, Position>>>
	private MutableIntObjectMap<MutableIntObjectMap<Position>> clientPositionMap = new IntObjectHashMap<>();

	// Map<clOrdId, lastCumQty>
	private MutableLongIntMap orderLastQty = new LongIntHashMap();

	@PostConstruct
	private void init() {
		log.info("PositionStorage initialized...");
	}

	public void inFixPosition(FixPosition fixPosition) {
		Position position = Position.newBuilder().setStrategyId(-1).setClientId(fixPosition.getClientId())
				.setAccountId(-1)
				.setInstrumentId(
						InstrumentIdHelper.getInstrumentId(fixPosition.getSecurityExchange(), fixPosition.getSymbol()))
				.setCurrentQty(0).setShortQty(fixPosition.getShortQty()).setTradableQty(fixPosition.getTradableQty())
				.setLockQty(0).build();
		putPosition(position);
	}

	public void inFixOrder(FixOrder fixOrder) {
		OrdStatus ordStatus = OrdStatus.checkout(fixOrder.getOrdStatus());
		Side side = Side.checkout(fixOrder.getSide());
		Position position = getPosition(fixOrder.getAccountId(),
				InstrumentIdHelper.getInstrumentId(fixOrder.getSecurityExchange(), fixOrder.getSymbol()));
		long clOrdId = fixOrder.getClOrdId();
		int lastQty = 0;
		if (orderLastQty.containsKey(clOrdId)) {
			lastQty = orderLastQty.get(clOrdId);
		}
		int cumQty = fixOrder.getCumQty();
		switch (side) {
		case Buy:
			switch (ordStatus) {
			case PartialFill:
				position.setCurrentQty(position.getCurrentQty() + cumQty - lastQty);
				orderLastQty.put(clOrdId, cumQty);
				break;
			case Filled:
				position.setCurrentQty(position.getCurrentQty() + cumQty - lastQty);
				orderLastQty.remove(clOrdId);
				break;
			default:
				break;
			}
			break;
		case Sell:
			int orderQty = fixOrder.getOrderQty();
			switch (ordStatus) {
			case PendingNew:
				position.setTradableQty(position.getTradableQty() - orderQty);
				break;
			case PartialFill:
				orderLastQty.put(clOrdId, cumQty);
				break;
			case Canceled:
			case Rejected:
				position.setTradableQty(position.getTradableQty() + orderQty - lastQty);
			default:
				break;
			}
			break;
		default:
			break;
		}

	}

	public Position getPosition(int accountId, int instrumentId) {
		int clientId = accountManager.getClientId(accountId);
		MutableIntObjectMap<Position> positionMap = getClientPositionMap(clientId);
		if (!positionMap.containsKey(instrumentId)) {
			positionMap.put(instrumentId,
					Position.newBuilder().setStrategyId(accountManager.getStrategyId(accountId)).setClientId(clientId)
							.setAccountId(accountId).setInstrumentId(instrumentId).setCurrentQty(0).setShortQty(0)
							.setTradableQty(0).setLockQty(0).build());
		}
		return positionMap.get(instrumentId);
	}

	private void putPosition(Position position) {
		MutableIntObjectMap<Position> positionMap = getClientPositionMap(position.getClientId());
		positionMap.put(position.getInstrumentId(), position);
	}

	private MutableIntObjectMap<Position> getClientPositionMap(int clientId) {
		if (clientPositionMap.containsKey(clientId)) {
			return clientPositionMap.get(clientId);
		} else {
			MutableIntObjectMap<Position> positionMap = new IntObjectHashMap<>();
			clientPositionMap.put(clientId, positionMap);
			return positionMap;
		}
	}

}
