package com.kafang.atgo.backup.service;

import com.kafang.atgo.backup.dao.BackupDao;
import com.kafang.atgo.backup.dao.BakMessage;
import io.ffreedom.common.datetime.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BackupServiceImpl implements BackupService {

	@Autowired
	private BackupDao backupDao;

	@Override
	public boolean saveBakMessage(LocalDateTime receivedDateTime, String msgType, int handlInst, String msgText) {
		log.info("Call method saveBakMessage(receivedDateTime==[{}], msgType==[{}]), handlInst==[{}], msgText==[...])",
				receivedDateTime, msgType, handlInst);
		return backupDao
				.insertOrUpdate(new BakMessage().setReceivedDate(DateTimeUtil.intDate(receivedDateTime.toLocalDate()))
						.setReceivedTime(DateTimeUtil.intTimeToMillisecond(receivedDateTime.toLocalTime()))
						.setMsgType(msgType).setHandlInst(handlInst).setMsgText(msgText)) > 0;
	}

	@Override
	public MutableSet<BackupMsg> getBackupMsgSet(LocalDate date, String msgType, int handlInst) {
		log.info("Call method getBackupMsgSet(date==[{}], msgType==[{}]), handlInst==[{}])", date, msgType, handlInst);
		return backupDao.selectBakMessage(DateTimeUtil.intDate(date), msgType, handlInst)
				.map(bakMessageList -> bakMessageList.stream()
						.map(bakMessage -> new BackupMsg(bakMessage.getReceivedDate(), bakMessage.getReceivedTime(),
								bakMessage.getMsgText()))
						.collect(Collectors.toCollection(UnifiedSet::new)))
				.orElse(UnifiedSet.newSet());
	}

}
