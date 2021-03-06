package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.WsUserDao;
import com.kafang.atgo.restful.entity.WsPhone;
import com.kafang.atgo.restful.entity.WsUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class WsUserDaoImpl implements WsUserDao {

    private Dao<WsUser, Long> innerDao;

    private Dao<WsPhone, Long> phoneDao;

    @Autowired
    public WsUserDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsUser.class);
        phoneDao = daoFactory.getDao(WsPhone.class);
    }

    @Override
    public Optional<WsUser> selectByUsername(String username) {
        try {
            List<WsUser> queryForEq = innerDao.queryForEq(WsUser.TableColumn.username, username);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query user error:", e);
        }
    }

    @Override
    public Optional<List<WsUser>> selectAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query all user error:", e);
        }
    }

    @Override
    public Optional<WsUser> selectById(long userId) {
        try {
            List<WsUser> list = innerDao.queryForEq(WsUser.TableColumn.userid, userId);
            return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query user by id error:", e);
        }

    }

    @Override
    public int insert(WsUser wu) {
        try {
            return innerDao.create(wu);
        } catch (SQLException e) {
            throw new AtgoException("insert user error:", e);
        }
    }

    public Optional<WsUser> selectByUserId(long userId) {
        try {
            List<WsUser> queryForEq = innerDao.queryForEq(WsUser.TableColumn.userid, userId);
            return queryForEq.size() > 0 ? Optional.of(queryForEq.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query user by id error:", e);
        }
    }

    @Override
    public Optional<List<WsUser>> getUsername(String usernamae) {
        try {
            return Optional.ofNullable(innerDao.queryForEq(WsUser.TableColumn.username, usernamae));
        } catch (SQLException e) {
            throw new AtgoException("query user by name error:", e);
        }
    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {

            throw new AtgoException("delete user error:", e);
        }
    }

    @Override
    public String selectUserId() {
        try {
            QueryBuilder<WsUser, Long> select = innerDao.queryBuilder().selectRaw("MAX(userid)");
            String[] queryRawFirst = select.queryRawFirst();
            return queryRawFirst[0];
        } catch (Exception e) {
            throw new AtgoException("query user error:", e);
        }
    }

    @Override
    public Optional<List<WsUser>> getuser(List<Long> userid) {
        try {
            if (CollectionUtils.isEmpty(userid)){
                return Optional.empty();
            }
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(WsUser.TableColumn.userid, StringUtils.strip(userid.toString(), "[]")).query());// StringUtils.strip去掉list数据[]
        } catch (SQLException e) {
            throw new AtgoException("query user error:", e);
        }
    }

    @Override
    public Optional<List<WsPhone>> getphone(List<Long> userid) {
        try {
            if (CollectionUtils.isEmpty(userid)){
                return Optional.empty();
            }
            return Optional.ofNullable(phoneDao.queryBuilder().where()
                    .in(WsPhone.TableColumn.userID, StringUtils.strip(userid.toString(), "[]")).query());
        } catch (SQLException e) {
            throw new AtgoException("query phone by user id error:", e);
        }
    }

    @Override
    public Optional<WsUser> getid(long id) {
        try {
            List<WsUser> list = innerDao.queryForEq(WsUser.TableColumn.userid, id);
            return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query user error:", e);
        }
    }

    @Override
    public int update(WsUser wu) {
        try {
            return innerDao.update(wu);
        } catch (SQLException e) {
            throw new AtgoException("update user error:", e);
        }
    }

}
