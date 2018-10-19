package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.WsAuditTrailDao;
import com.kafang.atgo.restful.entity.WsAuditTrail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class WsAuditTrailDaoImpl implements WsAuditTrailDao {

    private Dao<WsAuditTrail, Long> innerDao;

    @Autowired
    public WsAuditTrailDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsAuditTrail.class);
    }

    @Override
    public int insert(WsAuditTrail wa) {
        try {
            return innerDao.create(wa);
        } catch (SQLException e) {
            throw new AtgoException("insert WsAuditTrail error:", e);
        }
    }

}
