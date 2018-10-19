package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.AgClientDao;
import com.kafang.atgo.restful.entity.AgClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class AgClientDaoImpl implements AgClientDao {

    private Dao<AgClient, Long> innerDao;

    @Autowired
    public AgClientDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(AgClient.class);
    }

    @Override
    public Optional<AgClient> selectById(long customerId) {
        try {
            List<AgClient> queryForEq = innerDao.queryForEq(AgClient.TableColumn.CustomerID, customerId);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query client error:", e);
        }
    }

    @Override
    public Optional<List<AgClient>> selectByClientId(List<Integer> clientId) {
        try {
            innerDao.queryBuilder().where().in(AgClient.TableColumn.ClientID, clientId);// StringUtils.strip去掉list数据[]
            return Optional.ofNullable(
                    innerDao.queryForEq(AgClient.TableColumn.ClientID, StringUtils.strip(clientId.toString(), "[]")));
        } catch (SQLException e) {
            throw new AtgoException("query client error:", e);
        }
    }

    @Override
    public Optional<List<AgClient>> selectByCustomer(long customerId) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(AgClient.TableColumn.CustomerID, customerId));
        } catch (SQLException e) {
            throw new AtgoException("query client error:", e);
        }
    }

    @Override
    public int insert(AgClient agClient) {
        try {
            return innerDao.create(agClient);
        } catch (SQLException e) {
            throw new AtgoException("insert client error:", e);
        }
    }

    @Override
    public String selectid() {
        try {
            QueryBuilder<AgClient, Long> select = innerDao.queryBuilder().selectRaw("MAX(ClientID)");
            String[] queryRawFirst = select.queryRawFirst();
            return queryRawFirst[0];
        } catch (Exception e) {
            throw new AtgoException("query client error:", e);
        }
    }

    public static void main(String[] args) {
		 /*Dao<RptActual, Long> innerDao = OrmliteDaoFactory.getDao(RptActual.class);
		//Dao<AgClient, Long> innerDao = OrmliteDaoFactory.getDao(AgClient.class);
		try {
			*//*QueryBuilder<AgClient, Long> select = innerDao.queryBuilder().selectRaw("MAX(ClientID)");
			log.info(select.prepareStatementString());//打印出来sql语句
			String[] queryRawFirst = select.queryRawFirst();//取第一条
			log.info(queryRawFirst[0]);*//*
			int customerId=12;
			int strategyId=2002;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd HH:mm:ss
			Date asOfDate;
			Date stime;
			try {
				asOfDate = sdf.parse("2018-06-19");//2008-08-08 12:10:12
				stime=sdf.parse("2018-06-18");
				log.info(""+innerDao.queryBuilder().where().eq(RptActual.TableColumn.CustomerID, customerId).and()
						.eq(RptActual.TableColumn.StrategyID, strategyId).and().between(RptActual.TableColumn.AsOfDate, stime, asOfDate).query());;
			} catch (ParseException e) {
				log.error("", e);
			}
		} catch (SQLException e) {
			log.error("", e);
		}*/

    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("delete client error:", e);
        }
    }


}
