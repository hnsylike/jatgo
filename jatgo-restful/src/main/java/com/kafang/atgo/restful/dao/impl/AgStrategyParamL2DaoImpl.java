package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.AgStrategyParamL2Dao;
import com.kafang.atgo.restful.entity.AgStrategyParamL2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AgStrategyParamL2DaoImpl implements AgStrategyParamL2Dao {

    private Dao<AgStrategyParamL2, Long> innerDao;

    @Autowired
    public AgStrategyParamL2DaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(AgStrategyParamL2.class);
    }

    @Override
    public int insert(AgStrategyParamL2 agStrategyParamL2) {
        try {
            return innerDao.create(agStrategyParamL2);
        } catch (SQLException e) {
            throw new AtgoException("insert strategy error:", e);
        }

    }

    @Override
    public int update(AgStrategyParamL2 agStrategyParamL2) {
        try {
            return innerDao.update(agStrategyParamL2);
        } catch (SQLException e) {
            throw new AtgoException("update strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategyParamL2>> selectByCustomerId(List<Long> customerId) {
        try {
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(AgStrategyParamL2.TableColumn.CustomerID, StringUtils.strip(customerId.toString(), "[]"))
                    .query());// StringUtils.strip去掉list数据[]
            // 多条件查询
            // innerDao.queryBuilder().where().eq(AgStrategyParamL2.TableColumn.CustomerID,
            // customerId).and().eq(AgStrategyParamL2.TableColumn, value)
        } catch (SQLException e) {
            throw new AtgoException("query strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategyParamL2>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategyParamL2>> selectById(int strategyId) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(AgStrategyParamL2.TableColumn.StrategyID, strategyId));
        } catch (Exception e) {
            // TODO: handle exception
            throw new AtgoException("query strategy error:", e);
        }
    }

}
