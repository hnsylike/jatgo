package com.kafang.atgo.backup.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.eclipse.collections.api.set.MutableSet;

public interface BackupService {

    boolean saveBakMessage(LocalDateTime receivedDateTime, String msgType, int handlInst, String msgText);

    MutableSet<BackupMsg> getBackupMsgSet(LocalDate date, String msgType, int handlInst);

}
