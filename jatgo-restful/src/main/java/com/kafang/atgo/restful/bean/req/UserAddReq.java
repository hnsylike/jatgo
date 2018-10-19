package com.kafang.atgo.restful.bean.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author like
 * @description 用户新增bean
 * @data 2018/10/18
 */
@Getter
@Setter
@ToString
public class UserAddReq  {

    private Long id;

    private Long userid;

    private String username;

    private String password;

    private String role;

    private long customerId;

    private String phone;

    private List<Long> orderIds;

}
