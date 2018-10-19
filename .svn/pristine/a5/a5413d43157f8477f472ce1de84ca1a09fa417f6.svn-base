package com.kafang.atgo.restful.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.kafang.atgo.AtgoException;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.bean.req.PermissionPageReq;
import com.kafang.atgo.restful.dao.api.WsPermissionDao;
import com.kafang.atgo.restful.entity.WsPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author like
 * @description 资源dao
 * @data 2018/10/17
 */
@Repository
public class WsPermissionDaoImpl implements WsPermissionDao {

    private Dao<WsPermission, Long> innerDao;

    @Autowired
    public WsPermissionDaoImpl(OrmliteDaoFactory daoFactory) {
        innerDao = daoFactory.getDao(WsPermission.class);
    }

    @Override
    public int insert(WsPermission wsPermission) {
        try {
            return innerDao.create(wsPermission);
        } catch (SQLException e) {
            throw new AtgoException("insert Permission error:", e);
        }
    }

    @Override
    public int del(long id) {
        try {
            return innerDao.deleteById(id);
        } catch (SQLException e) {
            throw new AtgoException("del Permission error:", e);
        }
    }

    @Override
    public int update(WsPermission wsPermission) {
        try {
            return innerDao.update(wsPermission);
        } catch (SQLException e) {
            throw new AtgoException("update Permission error:", e);
        }
    }

    @Override
    public Optional<WsPermission> queryById(Long id) {
        try {
            List<WsPermission> list = innerDao.queryForEq(WsPermission.TableColumn.id, id);
            return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query Permission by id error:", e);
        }
    }

    @Override
    public Optional<List<WsPermission>> queryByIds(List<Long> ids) {
        try {
            return Optional.ofNullable(innerDao.queryBuilder().where()
                    .in(WsPermission.TableColumn.id, ids.stream().map(p -> p + "").collect(Collectors.joining(","))).query());
        } catch (SQLException e) {
            throw new AtgoException("query Permission by id error:", e);
        }
    }

    @Override
    public Optional<WsPermission> queryByPermissionId(Long permissionId) {
        try {
            List<WsPermission> list = innerDao.queryForEq(WsPermission.TableColumn.permissionId, permissionId);
            return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new AtgoException("query Permission by permissionId error:", e);
        }
    }

    @Override
    public Optional<List<WsPermission>> queryByParam(PermissionPageReq permissionReq, Long offset, Long limit) {
        QueryBuilder builder = innerDao.queryBuilder();
        Where where = builder.where();
        try {
            where.ge("id", 0);
            if (permissionReq.getPermissionMethod() != null) {
                where.and().eq(WsPermission.TableColumn.permissionMethod, permissionReq.getPermissionMethod());
            }
            if (permissionReq.getPermissionName() != null) {
                where.and().like(WsPermission.TableColumn.permissionName, permissionReq.getPermissionName() + "%");
            }
            if (permissionReq.getPermissionUrl() != null) {
                where.and().like(WsPermission.TableColumn.permissionUrl, permissionReq.getPermissionUrl() + "%");
            }
            if (permissionReq.getWhite() != null) {
                where.and().eq(WsPermission.TableColumn.white, permissionReq.getWhite());
            }

            builder.offset(offset).limit(limit);
            builder.orderBy(WsPermission.TableColumn.id, false);
            return Optional.ofNullable(where.query());
        } catch (SQLException e) {
            throw new AtgoException("query Permission by param=" + permissionReq.toString() + " error:", e);
        }
    }

    @Override
    public Optional<List<WsPermission>> queryByUrlAndMethod(String permissionUrl, String permissionMethod) {
        QueryBuilder builder = innerDao.queryBuilder();
        Where where = builder.where();
        try {
            where.eq(WsPermission.TableColumn.permissionMethod, permissionMethod);
            where.and().like(WsPermission.TableColumn.permissionUrl, permissionUrl + "%");

            return Optional.ofNullable(where.query());
        } catch (SQLException e) {
            throw new AtgoException("query Permission by permissionUrl=" + permissionUrl + ", permissionMethod=" + permissionMethod + " error:", e);
        }
    }

    @Override
    public long count(PermissionPageReq permissionReq) {
        QueryBuilder builder = innerDao.queryBuilder();
        Where where = builder.where();
        try {
            where.ge("id", 0);
            if (permissionReq.getPermissionMethod() != null) {
                where.and().eq(WsPermission.TableColumn.permissionMethod, permissionReq.getPermissionMethod());
            }
            if (permissionReq.getPermissionName() != null) {
                where.and().like(WsPermission.TableColumn.permissionName, permissionReq.getPermissionName() + "%");
            }
            if (permissionReq.getPermissionUrl() != null) {
                where.and().like(WsPermission.TableColumn.permissionUrl, permissionReq.getPermissionUrl() + "%");
            }
            if (permissionReq.getWhite() != null) {
                where.and().eq(WsPermission.TableColumn.white, permissionReq.getWhite());
            }

            return where.countOf();
        } catch (SQLException e) {
            throw new AtgoException("count Permission by param=" + permissionReq.toString() + " error:", e);
        }
    }

    @Override
    public Optional<List<WsPermission>> queryAll() {
        try {
            return Optional.ofNullable(innerDao.queryForAll());
        } catch (SQLException e) {
            throw new AtgoException("query all Permission error:", e);
        }
    }
}
