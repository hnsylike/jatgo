package com.kafang.atgo.backup.dao;

import java.util.List;
import java.util.Optional;

public interface BackupDao {

	int insertOrUpdate(BakMessage bakMessage);

	Optional<List<BakMessage>> selectAllBakMessage();

	Optional<List<BakMessage>> selectBakMessage(int date, String msgType, int handlInst);

}
