package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.WsRoleDao;
import com.kafang.atgo.restful.entity.WsRole;
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
 * @description 角色dao
 * @data 2018/10/17
 */
@Repository
public class WsRoleDaoImpl implements WsRoleDao {

    private Dao<WsRole, Long> innerDao;

    @Autowired
    public WsRoleDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsRole.class);
    }

    @Override
    public int insert(WsRole wsRole) {
        try {
            return innerDao.create(wsRole);
        } catch (SQLException e) {
            throw new AtgoException("insert Role error:", e);
        }
    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("del Role error:", e);
        }
    }

    @Override
    public int update(WsRole wsRole) {
        try {
            return innerDao.update(wsRole);
        } catch (SQLException e) {
            throw new AtgoException("update Role error:", e);
        }
    }

    @Override
    public Optional<List<WsRole>> queryByRoleIds(List<Long> roleIds) {
        try {
            if (CollectionUtils.isEmpty(roleIds)) {
                return Optional.empty();
            }
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(WsUserRole.TableColumn.roleId, roleIds.stream().map(p -> p + "").collect(Collectors.joining(","))).query());
        } catch (SQLException e) {
            throw new AtgoException("query Role by roleId error:", e);
        }
    }

    @Override
    public Optional<List<WsRole>> queryAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query all Role error:", e);
        }
    }
}
