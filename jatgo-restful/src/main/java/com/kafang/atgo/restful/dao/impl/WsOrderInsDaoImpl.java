package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.WsOrderInsDao;
import com.kafang.atgo.restful.entity.WsOrderIns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class WsOrderInsDaoImpl implements WsOrderInsDao {
    private Dao<WsOrderIns, Long> innerDao;

    @Autowired
    public WsOrderInsDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsOrderIns.class);
    }

    @Override
    public int insert(WsOrderIns wsOrderIns) {
        try {
            return innerDao.create(wsOrderIns);
        } catch (SQLException e) {
            throw new AtgoException("insert order error:", e);
        }
    }

    @Override
    public int update(WsOrderIns wsOrderIns) {
        try {
            return innerDao.update(wsOrderIns);
        } catch (SQLException e) {
            throw new AtgoException("update order error:", e);
        }
    }

    @Override
    public Optional<List<WsOrderIns>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query order error:", e);
        }
    }

    @Override
    public Optional<List<WsOrderIns>> selectByReview(int Clientid) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(WsOrderIns.TableColumn.ClientID, Clientid));
        } catch (SQLException e) {
            throw new AtgoException("query order error:", e);
        }

    }

    @Override
    public Optional<List<WsOrderIns>> selectById(Long id) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(WsOrderIns.TableColumn.id, id));
        } catch (SQLException e) {
            throw new AtgoException("query order error:", e);
        }

    }

}
