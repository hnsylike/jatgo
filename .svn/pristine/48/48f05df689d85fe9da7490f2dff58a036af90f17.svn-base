package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.dao.api.WsRolePermissionDao;
import com.kafang.atgo.restful.entity.WsRolePermission;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author like
 * @description 角色资源dao
 * @data 2018/10/17
 */
@Repository
public class WsRolePermissionDaoImpl implements WsRolePermissionDao {

    private Dao<WsRolePermission, Long> innerDao;

    @Autowired
    public WsRolePermissionDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsRolePermission.class);
    }

    @Override
    public int insert(WsRolePermission wsRolePermission) {
        try {
            return innerDao.create(wsRolePermission);
        } catch (SQLException e) {
            throw new AtgoException("insert RolePermission error:", e);
        }
    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("del RolePermission error:", e);
        }
    }

    @Override
    public int update(WsRolePermission wsRolePermission) {
        try {
            return innerDao.update(wsRolePermission);
        } catch (SQLException e) {
            throw new AtgoException("update RolePermission error:", e);
        }
    }

    @Override
    public Optional<List<WsRolePermission>> queryByRoleIds(List<Long> roleIds) {
        try {
            if (CollectionUtils.isEmpty(roleIds)) {
                return Optional.empty();
            }
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(WsRolePermission.TableColumn.roleId, roleIds.stream().map(p -> p + "").collect(Collectors.joining(","))).query());
        } catch (SQLException e) {
            throw new AtgoException("query RolePermission by roleIds error:", e);
        }
    }

    @Override
    public Optional<List<WsRolePermission>> queryByPermissionIds(List<Long> permissionIds) {
        try {
            if (CollectionUtils.isEmpty(permissionIds)) {
                return Optional.empty();
            }
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(WsRolePermission.TableColumn.permissionId, permissionIds.stream().map(p -> p + "").collect(Collectors.joining(","))).query());
        } catch (SQLException e) {
            throw new AtgoException("query RolePermission by permissionIds error:", e);
        }
    }
}
