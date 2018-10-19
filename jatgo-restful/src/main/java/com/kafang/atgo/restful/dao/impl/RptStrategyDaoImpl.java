package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.RptStrategyDao;
import com.kafang.atgo.restful.entity.RptStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class RptStrategyDaoImpl implements RptStrategyDao {

    private Dao<RptStrategy, Long> innerDao;

    @Autowired
    public RptStrategyDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(RptStrategy.class);
    }

    @Override
    public Optional<List<RptStrategy>> selectByCustomer(long customerId, int strategyId, Date stime, Date endtime) {
        try {
            return Optional
                    .ofNullable(innerDao.queryBuilder().where().eq(RptStrategy.TableColumn.CustomerID, customerId).and()
                            .eq(RptStrategy.TableColumn.StrategyID, strategyId).and()
                            .between(RptStrategy.TableColumn.AsOfDate, stime, endtime).query());
        } catch (SQLException e) {
            throw new AtgoException("query database error:", e);
        }
    }

}
