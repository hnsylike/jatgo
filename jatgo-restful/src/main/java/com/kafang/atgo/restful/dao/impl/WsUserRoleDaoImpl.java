package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.WsUserRoleDao;
import com.kafang.atgo.restful.entity.WsUserRole;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author like
 * @description 用户角色dao
 * @data 2018/10/17
 */
@Repository
public class WsUserRoleDaoImpl implements WsUserRoleDao {

    private Dao<WsUserRole, Long> innerDao;

    @Autowired
    public WsUserRoleDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsUserRole.class);
    }

    @Override
    public int insert(WsUserRole wsUserRole) {
        try {
            return innerDao.create(wsUserRole);
        } catch (SQLException e) {
            throw new AtgoException("insert UserRole error:", e);
        }

    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("del UserRole error:", e);
        }
    }

    @Override
    public int update(WsUserRole wsUserRole) {
        try {
            return innerDao.update(wsUserRole);
        } catch (SQLException e) {
            throw new AtgoException("update UserRole error:", e);
        }
    }

    @Override
    public Optional<List<WsUserRole>> queryByUserIds(List<Long> userIds) {
        try {
            if (CollectionUtils.isEmpty(userIds)) {
                return Optional.empty();
            }
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(WsUserRole.TableColumn.userId, userIds.stream().map(p -> p + "").collect(Collectors.joining(","))).query());
        } catch (SQLException e) {
            throw new AtgoException("query UserRole by userIds error:", e);
        }
    }

    @Override
    public Optional<List<WsUserRole>> queryByRoleIds(List<Long> roleIds) {
        try {
            if (CollectionUtils.isEmpty(roleIds)) {
                return Optional.empty();
            }
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(WsUserRole.TableColumn.roleId, roleIds.stream().map(p -> p + "").collect(Collectors.joining(","))).query());
        } catch (SQLException e) {
            throw new AtgoException("query UserRole by roleIds error:", e);
        }
    }

    @Override
    public Optional<List<WsUserRole>> queryAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query all UserRole error:", e);
        }
    }

}
