package com.kafang.atgo.restful.entity;

import com.kafang.atgo.persistence.db.base.entity.SimpleEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author like
 * @description 角色
 * @data 2018/10/17
 */
@Getter
@Setter
@ToString
@Entity(name = "WS_ROLE")
public class WsRole implements SimpleEntity {

    public interface TableColumn {
        String id = "id";
        String roleId = "roleId";
        String roleName = "roleName";
        String remark = "remark";
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roleId", length = 11, nullable = false)
    private Long roleId;

    @Column(name = "roleName", length = 32, nullable = false)
    private String roleName;

    @Column(name = "remark", length = 32, nullable = false)
    private String remark;


}
