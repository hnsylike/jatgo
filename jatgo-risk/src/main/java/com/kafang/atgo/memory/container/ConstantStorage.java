package com.kafang.atgo.memory.container;

import com.kafang.atgo.memory.avro.record.Balance;
import com.kafang.atgo.memory.avro.record.Status;

class ConstantStorage {

	final static Balance emptyBalance = Balance.newBuilder().setClientId(-1).setAccountId(-1).setCreditBalance(0D)
			.setEnableBalance(0D).build();

	final static Status emptyStatus = Status.newBuilder().setClientId(-1).setAccountId(-1).setModuleStatus(-1).build();

	final static int emptyAccountId = -1;

	final static int emptyQuoteId = -1;

}
