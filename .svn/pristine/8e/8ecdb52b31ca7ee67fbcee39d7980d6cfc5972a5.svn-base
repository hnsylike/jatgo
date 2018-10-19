package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.AgStrategyDao;
import com.kafang.atgo.restful.entity.AgStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AgStrategyDaoImpl implements AgStrategyDao {

    private Dao<AgStrategy, Long> innerDao;

    @Autowired
    public AgStrategyDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(AgStrategy.class);
    }

    @Override
    public int insert(AgStrategy agStrategy) {
        try {
            return innerDao.create(agStrategy);
        } catch (SQLException e) {
            throw new AtgoException("insert strategy error:", e);
        }
    }

    @Override
    public int update(AgStrategy agStrategy) {
        try {
            return innerDao.update(agStrategy);
        } catch (SQLException e) {
            throw new AtgoException("update strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategy>> selectById(int strategyId) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(AgStrategy.TableColumn.StrategyID, strategyId));
        } catch (SQLException e) {
            throw new AtgoException("query strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategy>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query strategy error:", e);
        }

    }

}
