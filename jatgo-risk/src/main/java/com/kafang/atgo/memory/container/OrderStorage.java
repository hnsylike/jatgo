package com.kafang.atgo.memory.container;

import java.time.Instant;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.eclipse.collections.api.map.primitive.MutableLongIntMap;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.springframework.beans.factory.annotation.Autowired;

import com.kafang.atgo.bean.fix.FixCancelOrder;
import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.bean.fix.enums.OrdStatus;
import com.kafang.atgo.memory.avro.record.Order;
import com.kafang.atgo.memory.manager.AccountManager;
import com.kafang.atgo.memory.manager.RiskManager;
import com.kafang.atgo.memory.utils.InstrumentIdHelper;

import io.ffreedom.common.datetime.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderStorage {

	// public static final OrderStorage INSTANCE = new OrderStorage();

	@Autowired
	private RiskManager riskManager;

	@Autowired
	private AccountManager accountManager;

	@Autowired
	private BalanceStorage balanceStorage;

	@Autowired
	private PositionStorage positionStorage;

	// structure -> Map<accountId, Set<clOrdId>>
	private MutableSetMultimap<Integer, Long> accountIdClOrdIdMap = new UnifiedSetMultimap<>();

	// structure -> Map<clientId, Set<clOrdId>>
	private MutableSetMultimap<Integer, Long> clientIdClOrdIdMap = new UnifiedSetMultimap<>();

	// structure -> Map<strategyId, Set<clOrdId>>
	private MutableSetMultimap<Integer, Long> strategyIdClOrdIdMap = new UnifiedSetMultimap<>();

	// structure -> Map<clOrdId, accountId>
	private MutableLongIntMap clOrdIdAccountIdMap = new LongIntHashMap();

	// structure -> Map<clOrdId, strategyId>
	private MutableLongIntMap clOrdIdClientIdMap = new LongIntHashMap();

	// structure -> Map<clOrdId, strategyId>
	private MutableLongIntMap clOrdIdStrategyIdMap = new LongIntHashMap();

	// structure -> Map<clOrdId, order>>
	private MutableLongObjectMap<Order> orderMap = new LongObjectHashMap<>();

	@PostConstruct
	private void init() {
		log.info("OrderStorage initialized...");
	}

	public void inFixOrder(FixOrder fixOrder) {
		OrdStatus ordStatus = OrdStatus.checkout(fixOrder.getOrdStatus());
		log.info("inFixOrder clOrdId -> {}, ordStatus -> {}", fixOrder.getClOrdId(), ordStatus);
		switch (ordStatus) {
		case PendingNew:
			boolean newOrderChecked = riskManager.newOrderRiskCheck(fixOrder);
			log.info("PendingNew Order Validation Risk Result is [{}]", newOrderChecked);
			if (newOrderChecked) {
				Order pendingNewOrder = generatePendingNewOrder(fixOrder);
				savePendingNewOrder(pendingNewOrder);
				forwardToBalanceStorage(fixOrder);
				forwardToPositionStorage(fixOrder);
				sendToAdaptor(fixOrder);
			} else {
				sendBackToStrategy(fixOrder);
			}
			break;
		case PendingCancel:

			break;
		case New:
		case Canceled:
		case Filled:
		case PartialFill:
		case Rejected:
			updateOrder(fixOrder);
			break;
		default:
			break;
		}
	}

	private void savePendingNewOrder(Order order) {
		orderMap.put(order.getClOrdId(), order);
		saveRelations(order.getClOrdId(), order.getAccountId(), order.getClientId(), order.getStrategyId());
	}

	private void saveRelations(long clOrdId, int accountId, int clientId, int strategyId) {
		accountIdClOrdIdMap.put(accountId, clOrdId);
		clientIdClOrdIdMap.put(clientId, clOrdId);
		strategyIdClOrdIdMap.put(strategyId, clOrdId);
		clOrdIdAccountIdMap.put(clOrdId, accountId);
		clOrdIdClientIdMap.put(clOrdId, clientId);
		clOrdIdStrategyIdMap.put(clOrdId, strategyId);
	}

	private void forwardToBalanceStorage(FixOrder fixOrder) {
		balanceStorage.inFixOrder(fixOrder);
	}

	private void forwardToPositionStorage(FixOrder fixOrder) {
		positionStorage.inFixOrder(fixOrder);
	}

	public void inFixCancelOrder(FixCancelOrder fixCancelOrder) {

	}

	public MutableSet<Order> getOrders4AccountId(int accountId) {
		return accountIdClOrdIdMap.get(accountId).stream().map(clOrdId -> orderMap.get(clOrdId.longValue()))
				.collect(Collectors.toCollection(UnifiedSet::new));
	}

	public MutableSet<Order> getOrders4Client(int clientId) {
		return clientIdClOrdIdMap.get(clientId).stream().map(clOrdId -> orderMap.get(clOrdId.longValue()))
				.collect(Collectors.toCollection(UnifiedSet::new));
	}

	public MutableSet<Order> getOrders4StrategyId(int strategyId) {
		return strategyIdClOrdIdMap.get(strategyId).stream().map(clOrdId -> orderMap.get(clOrdId.longValue()))
				.collect(Collectors.toCollection(UnifiedSet::new));
	}

	private void sendBackToStrategy(FixOrder fixOrder) {

	}

	private void sendToAdaptor(FixOrder fixOrder) {

	}

	private Order generatePendingNewOrder(FixOrder fixOrder) {
		return Order.newBuilder()
				// 发送时间戳
				.setSendingTime(DateTimeUtil.datetimeToMillisecond(fixOrder.getSendingTime()))
				// 本地时间戳
				.setLocalTimestamp(Instant.now().toEpochMilli())
				// Set ClOrdId (订单编号)
				.setClOrdId(fixOrder.getClOrdId())
				// Set StrategyId (策略)
				.setStrategyId(accountManager.getStrategyId(fixOrder.getAccountId()))
				// Set ClientId (母账户)
				.setClientId(accountManager.getClientId(fixOrder.getAccountId()))
				// Set AccountId (子帐号)
				.setAccountId(fixOrder.getAccountId())
				// Set InstrumentId
				.setInstrumentId(
						InstrumentIdHelper.getInstrumentId(fixOrder.getSecurityExchange(), fixOrder.getSymbol()))
				// Set HandlInst (级别)
				.setHandlInst(fixOrder.getHandlInst())
				// Set QuoteId (母单编号)
				.setQuoteId(fixOrder.getQuoteId())
				// Set Symbol & SecurityType & SecurityExchange
				.setSymbol(fixOrder.getSymbol()).setSecurityType(fixOrder.getSecurityType())
				.setSecurityExchange(fixOrder.getSecurityExchange())
				// Set Side & OrdType & Price OrderQty
				.setSide(fixOrder.getSide()).setOrderQty(fixOrder.getOrderQty()).setOrdType(fixOrder.getOrdType())
				.setPrice(fixOrder.getPrice())
				// Set CumQty == 0 & LeavesQty == OrderQty
				.setCumQty(0).setLeavesQty(fixOrder.getOrderQty())
				// Set OrdStatus == PendingNew
				.setOrdStatus(OrdStatus.PendingNew.code())
				// Build complete
				.build();
	}

	private void updateOrder(FixOrder fixOrder) {

	}

	public static void main(String[] args) {

	}

}
