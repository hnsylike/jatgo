package com.kafang.atgo.persistence.factory;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;


@Slf4j
public class OrmliteDaoFactory {
    private ConnectionFactory connectionFactory;

    public OrmliteDaoFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    private <T, ID> Dao<T, ID> getDaoInternal(Class<T> clazz) {
        try {
            return DaoManager.createDao(connectionFactory.getConnectionSource(), clazz);
        } catch (SQLException e) {
            log.error("getDaoInternal", e);
            return null;
        }
    }

    public <T, ID> Dao<T, ID> getDao(Class<T> clazz) {
        return getDaoInternal(clazz);
    }

}
