package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.AgStrategyParamL1Dao;
import com.kafang.atgo.restful.entity.AgStrategyParamL1;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AgStrategyParamL1DaoImpl implements AgStrategyParamL1Dao {

    private Dao<AgStrategyParamL1, Long> innerDao;

    @Autowired
    public AgStrategyParamL1DaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(AgStrategyParamL1.class);
    }

    @Override
    public int insert(AgStrategyParamL1 agStrategyParamL1) {
        try {
            return innerDao.create(agStrategyParamL1);
        } catch (SQLException e) {
            throw new AtgoException("insert strategy error:", e);
        }

    }

    @Override
    public int update(AgStrategyParamL1 agStrategyParamL1) {
        try {
            return innerDao.update(agStrategyParamL1);
        } catch (SQLException e) {
            throw new AtgoException("update strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategyParamL1>> selectById(int id) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(AgStrategyParamL1.TableColumn.id, id));
        } catch (SQLException e) {
            throw new AtgoException("query strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategyParamL1>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query strategy error:", e);
        }

    }

    @Override
    public Optional<List<AgStrategyParamL1>> selectByAccountId(List<Integer> accountId) {
        try {
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(AgStrategyParamL1.TableColumn.AccountID, StringUtils.strip(accountId.toString(), "[]"))
                    .query());// StringUtils.strip去掉list数据[]
        } catch (Exception e) {
            throw new AtgoException("query strategy error:", e);
        }
    }

}
