package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.QueryBuilder;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.WsUserCustomerMpDao;
import com.kafang.atgo.restful.entity.WsUserCustomerMp;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class WsUserCustomerMpDaoImpl implements WsUserCustomerMpDao {

    private Dao<WsUserCustomerMp, Long> innerDao;

    @Autowired
    public WsUserCustomerMpDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsUserCustomerMp.class);
    }

    @Override
    public Optional<WsUserCustomerMp> selectById(long customerId) {
        try {
            List<WsUserCustomerMp> queryForEq = innerDao.queryForEq(WsUserCustomerMp.TableColumn.CustomerID,
                    customerId);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query database error:", e);
        }
    }

    @Override
    public Optional<WsUserCustomerMp> selectByUserId(long userid) {
        try {
            List<WsUserCustomerMp> queryForEq = innerDao.queryForEq(WsUserCustomerMp.TableColumn.UserID, userid);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query database error:", e);
        }
    }

    @Override
    public int update(WsUserCustomerMp wcm) {
        try {
            return innerDao.update(wcm);
        } catch (SQLException e) {
            throw new AtgoException("update database error:", e);
        }
    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("delete database error:", e);
        }
    }

    @Override
    public Optional<List<WsUserCustomerMp>> getId(long customerId) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(WsUserCustomerMp.TableColumn.CustomerID, customerId));
        } catch (SQLException e) {
            throw new AtgoException("query database error:", e);
        }
    }

    @Override
    public List<String[]> getUser(long customerId) {
        try {// 两表关联查询
            StringBuilder sqlbd = new StringBuilder(
                    "select a.userid,a.username,a.`password`,a.role,b.CustomerID from WS_USER as a ");
            sqlbd.append("INNER JOIN WS_USER_CUSTOMER_MP as b on b.UserID=a.userid  where b.CustomerID=" + customerId);
            GenericRawResults<String[]> rawResults = innerDao.queryRaw(sqlbd.toString());
            List<String[]> results = rawResults.getResults();
            return results;
        } catch (SQLException e) {
            throw new AtgoException("query database error:", e);
        }
    }

    @Override
    public int insert(WsUserCustomerMp wcm) {
        try {
            return innerDao.create(wcm);
        } catch (SQLException e) {
            throw new AtgoException("insert database error:", e);
        }
    }

    @Override
    public String selectCustomerId() {
        try {
            QueryBuilder<WsUserCustomerMp, Long> select = innerDao.queryBuilder().selectRaw("MAX(CustomerID)");
            String[] queryRawFirst = select.queryRawFirst();
            return queryRawFirst[0];
        } catch (Exception e) {
            throw new AtgoException("query database error:", e);
        }
    }

    @Override
    public String selectUserId() {
        try {
            QueryBuilder<WsUserCustomerMp, Long> select = innerDao.queryBuilder().selectRaw("MAX(UserID)");
            String[] queryRawFirst = select.queryRawFirst();
            return queryRawFirst[0];
        } catch (Exception e) {
            throw new AtgoException("query database error:", e);
        }
    }

    @Override
    public Optional<List<WsUserCustomerMp>> getCustomer(long customerId) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(WsUserCustomerMp.TableColumn.CustomerID, customerId));
        } catch (SQLException e) {
            throw new AtgoException("query database error:", e);
        }
    }

    @Override
    public Optional<List<WsUserCustomerMp>> selectByCustomerIds(List<Long> customerIds) {
        try {
            List<WsUserCustomerMp> list = innerDao.queryBuilder().where()
                    .in(WsUserCustomerMp.TableColumn.CustomerID, StringUtils.join(customerIds.toArray(), ",")).query();
            return Optional.ofNullable(list);
        } catch (SQLException e) {
            throw new AtgoException("query database error:", e);
        }
    }
}
