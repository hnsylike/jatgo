package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.WsPhoenDao;
import com.kafang.atgo.restful.entity.WsPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class WsPhoenDaoImpl implements WsPhoenDao {

    private Dao<WsPhone, Long> innerDao;

    @Autowired
    public WsPhoenDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsPhone.class);
    }

    @Override
    public Optional<WsPhone> selectByPhone(String phone) {
        try {
            List<WsPhone> queryForEq = innerDao.queryForEq(WsPhone.TableColumn.phone, phone);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query phone error:", e);
        }
    }

    @Override
    public int insert(WsPhone wp) {
        try {
            return innerDao.create(wp);
        } catch (SQLException e) {
            throw new AtgoException("insert phone error:", e);
        }

    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("delete phone error:", e);
        }
    }

    @Override
    public Optional<WsPhone> selectByUserId(long userId) {
        try {
            List<WsPhone> queryForEq = innerDao.queryForEq(WsPhone.TableColumn.userID, userId);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query phone error:", e);
        }
    }

}
