package com.kafang.atgo.restful.bean.rep;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author like
 * @description 资源response
 * @data 2018/10/17
 */
@Getter
@Setter
public class PermissionRep {

    private Long id;

    private Long permissionId;

    private String permissionUrl;

    private String permissionName;

    private String permissionMethod;

    private Boolean white;

    private List<RolePermission>  rolePermissions;

    private List<Role> roles;

    @Getter
    @Setter
    public static class RolePermission {

        private Long id;

        private Long roleId;

    }

    @Getter
    @Setter
    public static class Role {

        private Long id;

        private Long roleId;

        private String roleName;

        private String remark;

    }
}
