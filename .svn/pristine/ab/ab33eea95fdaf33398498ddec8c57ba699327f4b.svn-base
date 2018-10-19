package com.kafang.atgo.persistence.factory;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.kafang.atgo.AtgoException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.SQLException;

@Slf4j
public class ConnectionFactory {

    private JdbcPooledConnectionSource connectionSource;

    public ConnectionFactory(String dbUrl, int maxConnectionsFree) {
        try {
            this.connectionSource = new JdbcPooledConnectionSource(dbUrl);
            this.connectionSource.setMaxConnectionsFree(maxConnectionsFree);
        } catch (SQLException e) {
            throw new AtgoException("Failed to get DB connection", e);
        }
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public void closeConnection() {
        try {
            connectionSource.close();
        } catch (IOException e) {
            log.error("Failed to close DB connection", e);
        }
    }

}
