package com.kafang.atgo.memory.container;

import javax.annotation.PostConstruct;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafang.atgo.bean.fix.FixStatus;
import com.kafang.atgo.memory.avro.record.Status;
import com.kafang.atgo.memory.manager.AccountManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StatusStorage {

	// public static final StatusStorage INSTANCE = new StatusStorage();

	@Autowired
	private AccountManager accountManager;

	// Map<accountID, status>
	private MutableIntObjectMap<Status> statusMap = new IntObjectHashMap<>();

	@PostConstruct
	private void init() {
		log.info("StatusStorage initialized...");
	}

	public void inFixStatus(FixStatus fixStatus) {
		accountManager.getAccountId4ClientId(fixStatus.getClientId()).forEach(accountID -> {
			statusMap.put(accountID, Status.newBuilder().setClientId(fixStatus.getClientId()).setAccountId(accountID)
					.setModuleStatus(fixStatus.getModuleStatus()).build());
		});
	}

	public Status getStatus(int accountId) {
		if (statusMap.containsKey(accountId)) {
			return statusMap.get(accountId);
		} else {
			return ConstantStorage.emptyStatus;
		}
	}

}
