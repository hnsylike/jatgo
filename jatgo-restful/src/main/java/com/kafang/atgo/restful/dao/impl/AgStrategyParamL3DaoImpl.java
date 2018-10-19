package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.AgStrategyParamL3Dao;
import com.kafang.atgo.restful.entity.AgStrategyParamL3;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AgStrategyParamL3DaoImpl implements AgStrategyParamL3Dao {

    private Dao<AgStrategyParamL3, Long> innerDao;

    @Autowired
    public AgStrategyParamL3DaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(AgStrategyParamL3.class);
    }

    @Override
    public int insert(AgStrategyParamL3 agStrategyParamL3) {
        try {
            return innerDao.create(agStrategyParamL3);
        } catch (SQLException e) {
            throw new AtgoException("insert strategy error:", e);
        }

    }

    @Override
    public int update(AgStrategyParamL3 agStrategyParamL3) {
        try {
            return innerDao.update(agStrategyParamL3);
        } catch (SQLException e) {
            throw new AtgoException("update strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategyParamL3>> selectById(int id) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(AgStrategyParamL3.TableColumn.id, id));
        } catch (SQLException e) {
            throw new AtgoException("query strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategyParamL3>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query strategy error:", e);
        }
    }

    @Override
    public Optional<List<AgStrategyParamL3>> selectByStrategyId(List<Integer> strategyId) {
        try {
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(AgStrategyParamL3.TableColumn.StrategyID, StringUtils.strip(strategyId.toString(), "[]"))
                    .query());// StringUtils.strip去掉list数据[]
        } catch (Exception e) {
            throw new AtgoException("query strategy error:", e);
        }

    }

}
