package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.AgCustomerDao;
import com.kafang.atgo.restful.entity.AgCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository
public class AgCustomerDaoImpl implements AgCustomerDao {

    private Dao<AgCustomer, Long> innerDao;

    @Autowired
    public AgCustomerDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(AgCustomer.class);
    }

    @Override
    public Optional<AgCustomer> selectById(long customerId) {
        try {
            List<AgCustomer> queryForEq = innerDao.queryForEq(AgCustomer.TableColumn.CustomerID, customerId);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query customer error:", e);
        }
    }

    @Override
    public Optional<List<AgCustomer>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query customer error:", e);
        }
    }

    @Override
    public int insert(AgCustomer ac) {
        try {
            return innerDao.create(ac);
        } catch (SQLException e) {
            throw new AtgoException("query customer error:", e);
        }
    }

    @Override
    public Optional<AgCustomer> selectByCustomer(String customerName) {
        try {
            List<AgCustomer> list = innerDao.queryForEq(AgCustomer.TableColumn.CustomerName, customerName);
            return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query customer error:", e);
        }

    }

    @Override
    public Optional<List<AgCustomer>> selectByCustomerName(String customerName) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(AgCustomer.TableColumn.CustomerName, customerName));
        } catch (SQLException e) {
            throw new AtgoException("query customer error:", e);
        }
    }

    @Override
    public String selectCustomerId() {
        try {
            QueryBuilder<AgCustomer, Long> select = innerDao.queryBuilder().selectRaw("MAX(CustomerID)");
            String[] queryRawFirst = select.queryRawFirst();
            return queryRawFirst[0];
        } catch (Exception e) {
            throw new AtgoException("query customer error:", e);
        }
    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("delete customer error:", e);
        }
    }


    public static void main(String[] args) {
		/*Dao<AgCustomer, Long> innerDao = OrmliteDaoFactory.getDao(AgCustomer.class);
		try {
			long id=28;
			innerDao.deleteById(id);
		} catch (SQLException e) {
			throw new AtgoException("sql exception:", e);
		}*/

    }

    @Override
    public Optional<AgCustomer> selectId(long id) {
        try {
            List<AgCustomer> queryForEq = innerDao.queryForEq(AgCustomer.TableColumn.CustomerID, id);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query customer error:", e);
        }
    }

}
