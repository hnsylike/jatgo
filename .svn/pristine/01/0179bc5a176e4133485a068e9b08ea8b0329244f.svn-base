package com.kafang.atgo.persistence.db.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.db.dao.api.AgAccountDao;
import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AgAccountDaoImpl implements AgAccountDao {

    private Dao<AgAccount, Long> innerDao;

    public AgAccountDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(AgAccount.class);
    }

    @Override
    public int insert(AgAccount agAccount) {
        try {
            return innerDao.create(agAccount);
        } catch (SQLException e) {
            throw new AtgoException("insert account error:", e);
        }
    }

    @Override
    public int update(AgAccount agAccount) {
        try {
            return innerDao.update(agAccount);
        } catch (SQLException e) {
            throw new AtgoException("update account error:", e);
        }

    }

    @Override
    public Optional<AgAccount> selectById(int strategyID) {
        try {
            List<AgAccount> list = innerDao.queryForEq(AgAccount.TableColumn.StrategyID, strategyID);
            return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query account error:", e);
        }

    }

    @Override
    public Optional<List<AgAccount>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (Exception e) {
            throw new AtgoException("query account error:", e);
        }
    }

    @Override
    public Optional<List<AgAccount>> selectByStrategyId(int StrategyId) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(AgAccount.TableColumn.StrategyID, StrategyId));
        } catch (Exception e) {
            throw new AtgoException("query account error:", e);
        }
    }

    @Override
    public Optional<AgAccount> selectByAccountId(long AccountId) {
        try {
            List<AgAccount> list = innerDao.queryForEq(AgAccount.TableColumn.AccountID, AccountId);
            return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
        } catch (Exception e) {
            throw new AtgoException("query account error:", e);
        }
    }

    @Override
    public Optional<AgAccount> selectByClient(long Clientid) {
        try {
            List<AgAccount> list = innerDao.queryForEq(AgAccount.TableColumn.ClientID, Clientid);
            return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
        } catch (Exception e) {
            throw new AtgoException("query account error:", e);
        }
    }

    @Override
    public Optional<List<AgAccount>> selectByClientId(long clientId) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(AgAccount.TableColumn.ClientID, clientId));
        } catch (Exception e) {
            throw new AtgoException("query account error:", e);
        }
    }

    @Override
    public String selectid() {
        try {
            QueryBuilder<AgAccount, Long> select = innerDao.queryBuilder().selectRaw("MAX(AccountID)");
            String[] queryRawFirst = select.queryRawFirst();
            return queryRawFirst[0];
        } catch (SQLException e) {
            throw new AtgoException("query account error:", e);
        }
    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("delete account error:", e);
        }
    }

}
