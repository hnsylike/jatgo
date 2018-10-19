package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.RptNominalDao;
import com.kafang.atgo.restful.entity.RptNominal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class RptNominalDaoImpl implements RptNominalDao {

    private Dao<RptNominal, Long> innerDao;

    @Autowired
    public RptNominalDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(RptNominal.class);
    }

    @Override
    public Optional<List<RptNominal>> selectByCustomer(long customerId, int strategyId, Date stime, Date endtime) {
        try {
            return Optional.ofNullable(innerDao.queryBuilder().where().eq(RptNominal.TableColumn.CustomerID, customerId)
                    .and().eq(RptNominal.TableColumn.StrategyID, strategyId).and()
                    .between(RptNominal.TableColumn.AsOfDate, stime, endtime).query());
        } catch (SQLException e) {
            throw new AtgoException("query database error:", e);
        }
    }

}
