package com.kafang.atgo.restful.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author like
 * @description 用户角色bean
 * @data 2018/10/17
 */
@Getter
@Setter
@ToString
@Entity(name = "WS_USER_ROLE")
public class WsUserRole {

    public interface TableColumn {
        String id = "id";
        String roleId = "roleId";
        String userId = "userId";
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roleId", length = 11, nullable = false)
    private Long roleId;

    @Column(name = "userId", length = 11, nullable = false)
    private Long userId;

}
