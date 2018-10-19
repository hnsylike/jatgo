package com.kafang.atgo.backup.dao;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class BackupDaoImpl implements BackupDao {

	private Dao<BakMessage, Long> bakMessageDao;

	@Autowired
	public BackupDaoImpl(OrmliteDaoFactory daoFactory) {
		bakMessageDao = daoFactory.getDao(BakMessage.class);
	}

	@Override
	public int insertOrUpdate(BakMessage bakMessage) {
		try {
			return bakMessageDao.createOrUpdate(bakMessage).getNumLinesChanged();
		} catch (SQLException e) {
			log.error("Call method insertOrUpdate(bakMessage) SQLState -> {}, Message -> {}", e.getSQLState(),
					e.getMessage(), e);
			return 0;
		}
	}

	@Override
	public Optional<List<BakMessage>> selectAllBakMessage() {
		try {
			return Optional.ofNullable(bakMessageDao.queryForAll());
		} catch (SQLException e) {
			log.error("Call method selectAllBakMessage() : SQLState -> {}, Message -> {}", e.getSQLState(),
					e.getMessage(), e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<List<BakMessage>> selectBakMessage(int date, String msgType, int handlInst) {
		try {
			return Optional.ofNullable(bakMessageDao.queryBuilder().where()
					.eq(BakMessage.TableColumn.ReceivedDate, date).and().eq(BakMessage.TableColumn.MsgType, msgType)
					.and().eq(BakMessage.TableColumn.HandlInst, handlInst).query());
		} catch (SQLException e) {
			log.error(
					"Call method selectBakMessage(date==[{}],msgType==[{}],handlInst==[{}]) : SQLState -> {}, Message -> {}",
					date, msgType, handlInst, e.getSQLState(), e.getMessage(), e);
			return Optional.empty();
		}
	}

}
