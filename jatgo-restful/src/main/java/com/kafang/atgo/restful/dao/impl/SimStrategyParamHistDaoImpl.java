package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.SimStrategyParamHistDao;
import com.kafang.atgo.restful.entity.SimStrategyParamHist;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class SimStrategyParamHistDaoImpl implements SimStrategyParamHistDao {

    private Dao<SimStrategyParamHist, Long> innerDao;

    @Autowired
    public SimStrategyParamHistDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(SimStrategyParamHist.class);
    }

    @Override
    public int insert(SimStrategyParamHist simStrategyParamHist) {
        try {
            return innerDao.create(simStrategyParamHist);
        } catch (SQLException e) {
            throw new AtgoException("insert database error:", e);
        }

    }

    @Override
    public int update(SimStrategyParamHist simStrategyParamHist) {
        try {
            return innerDao.update(simStrategyParamHist);
        } catch (SQLException e) {
            throw new AtgoException("update simStrategy error:", e);
        }

    }

    @Override
    public Optional<List<SimStrategyParamHist>> selectById(int id) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(SimStrategyParamHist.TableColumn.id, id));
        } catch (SQLException e) {
            throw new AtgoException("query simStrategy error:", e);
        }
    }

    @Override
    public Optional<List<SimStrategyParamHist>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query simStrategy error:", e);
        }
    }

}
