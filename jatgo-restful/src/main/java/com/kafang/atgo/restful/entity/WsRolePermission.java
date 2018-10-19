package com.kafang.atgo.restful.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author like
 * @description 角色资源bean
 * @data 2018/10/17
 */
@Getter
@Setter
@ToString
@Entity(name = "WS_ROLE_PERMISSION")
public class WsRolePermission {

    public interface TableColumn {
        String id = "id";
        String roleId = "roleId";
        String permissionId = "permissionId";
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roleId", length = 11, nullable = false)
    private Long roleId;

    @Column(name = "permissionId", length = 11, nullable = false)
    private Long permissionId;

}
