package com.kafang.atgo.memory.container;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafang.atgo.bean.fix.FixBalance;
import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.memory.avro.record.Balance;
import com.kafang.atgo.memory.manager.AccountManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public final class BalanceStorage {

	// public static final BalanceStorage INSTANCE = new BalanceStorage();

	@Autowired
	private AccountManager accountManager;

	private MutableIntObjectMap<Balance> clientBalanceMap = new IntObjectHashMap<>();

	@PostConstruct
	private void init() {
		log.info("BalanceStorage initialized...");
	}

	public void inFixBalance(FixBalance fixBalance) {
		clientBalanceMap.put(fixBalance.getClientId(),
				Balance.newBuilder().setAccountId(-1).setClientId(fixBalance.getClientId())
						.setCreditBalance(fixBalance.getCreditBalance()).setEnableBalance(fixBalance.getEnableBalance())
						.build());
	}

	public void inFixOrder(FixOrder fixOrder) {

	}

	public Balance getBalance(int accountId) {
		Balance balance = clientBalanceMap.get(accountManager.getClientId(accountId));
		return Objects.isNull(balance) ? ConstantStorage.emptyBalance : balance;
	}

}
