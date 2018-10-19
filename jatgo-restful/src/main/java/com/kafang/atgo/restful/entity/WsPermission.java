package com.kafang.atgo.restful.entity;

import com.kafang.atgo.persistence.db.base.entity.SimpleEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author like
 * @description 资源
 * @data 2018/10/17
 */
@Getter
@Setter
@ToString
@Entity(name = "WS_PERMISSION")
public class WsPermission implements SimpleEntity {

    public interface TableColumn {
        String id = "id";
        String permissionId = "permissionId";
        String permissionUrl = "permissionUrl";
        String permissionName = "permissionName";
        String permissionMethod = "permissionMethod";
        String white = "white";
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permissionId", length = 11, nullable = false)
    private Long permissionId;

    @Column(name = "permissionUrl", length = 100, nullable = false)
    private String permissionUrl;

    @Column(name = "permissionName", length = 100, nullable = true)
    private String permissionName;

    @Column(name = "permissionMethod", length = 100, nullable = false)
    private String permissionMethod;

    @Column(name = "white", length = 1, nullable = false)
    private Boolean white;
}
