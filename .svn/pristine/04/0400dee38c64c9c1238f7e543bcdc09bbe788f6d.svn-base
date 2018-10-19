package com.kafang.atgo.restful.config;


import com.kafang.atgo.restful.bean.rep.PermissionConfigBean;
import com.kafang.atgo.restful.entity.WsPermission;
import com.kafang.atgo.restful.entity.WsRolePermission;
import com.kafang.atgo.restful.service.api.WsPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author like
 * @description 权限config
 * @data 2018/10/18
 */

@Slf4j
@Component
public class PermissionConfig implements CommandLineRunner {

    @Autowired
    private WsPermissionService wsPermissionService;

    private static List<PermissionConfigBean> wsPermissionList = new CopyOnWriteArrayList<>();

    @Override
    public void run(String... var1) throws Exception {
        wsPermissionList.clear();
        List<WsPermission> wsPermissions = wsPermissionService.queryAll();
        List<Long> permissionIds = wsPermissions.stream().map(WsPermission::getPermissionId).collect(Collectors.toList());
        List<WsRolePermission> wsRolePermissions = wsPermissionService.queryByPermissionIds(permissionIds);
        Map<Long, List<WsRolePermission>> map = wsRolePermissions.stream().collect(Collectors.groupingBy(WsRolePermission::getPermissionId));

        for (WsPermission wsPermission : wsPermissions) {
            PermissionConfigBean permissionConfigBean = handlerBean(wsPermission);
            List<WsRolePermission> rolePermissions = map.get(wsPermission.getPermissionId());
            permissionConfigBean.setWsRolePermissions(rolePermissions);
            wsPermissionList.add(permissionConfigBean);
        }
    }

    /**
     * 内存中添加资源
     * @param permissionConfigBean
     * @return
     */
    public  List<PermissionConfigBean> addPermission(PermissionConfigBean permissionConfigBean) {
        wsPermissionList.add(permissionConfigBean);
        return wsPermissionList;
    }

    /**
     * 内存中修改资源
     * @param bean
     * @return
     */
    public  List<PermissionConfigBean> updatePermission(PermissionConfigBean bean) {
        for(PermissionConfigBean permissionConfigBean : wsPermissionList) {
            if(permissionConfigBean.getId().equals(bean.getId())) {
                permissionConfigBean = bean;
                break;
            }
        }
        return wsPermissionList;
    }

    /**
     * 内存中删除资源
     * @param ids
     * @return
     */
    public List<PermissionConfigBean> deletePermission(List<Long> ids) {
        for(PermissionConfigBean permissionConfigBean : wsPermissionList) {
            if(ids.contains(permissionConfigBean.getId())) {
                wsPermissionList.remove(permissionConfigBean);
            }
        }

        return wsPermissionList;
    }

    /**
     * 转换bean
     * @param wsPermission
     * @return
     */
    public static PermissionConfigBean handlerBean(WsPermission wsPermission) {
        PermissionConfigBean bean = new PermissionConfigBean();
        bean.setId(wsPermission.getId());
        bean.setPermissionId(wsPermission.getPermissionId());
        bean.setPermissionMethod(wsPermission.getPermissionMethod());
        bean.setPermissionName(wsPermission.getPermissionName());
        bean.setPermissionUrl(wsPermission.getPermissionUrl());
        bean.setWhite(wsPermission.getWhite());
        return bean;
    }

    /**
     * 查询内存中所有资源
     * @return
     */
    public List<PermissionConfigBean> querAllPermission() {
        return wsPermissionList;
    }

    /**
     * 刷新内存资源
     * @return
     */
    public List<PermissionConfigBean> refreshPermission() {
        try {
            run("");
        } catch (Exception e) {
            log.error("refresh permission error：", e);
        }

        return wsPermissionList;
    }
}
