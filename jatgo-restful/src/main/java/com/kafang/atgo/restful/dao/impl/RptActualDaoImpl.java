package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.RptActualDao;
import com.kafang.atgo.restful.entity.RptActual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class RptActualDaoImpl implements RptActualDao {

    private Dao<RptActual, Long> innerDao;

    @Autowired
    public RptActualDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(RptActual.class);
    }

    @Override
    public Optional<List<RptActual>> selectByCustomer(long customerId, int strategyId, String stime, String endtime) {
        try {
            return Optional.ofNullable(innerDao.queryBuilder().where().eq(RptActual.TableColumn.CustomerID, customerId)
                    .and().eq(RptActual.TableColumn.StrategyID, strategyId).and()
                    .between(RptActual.TableColumn.AsOfDate, stime, endtime).query());
        } catch (SQLException e) {
            throw new AtgoException("query RptActual error:", e);
        }
    }

}
