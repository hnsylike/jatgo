package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.WsUserCustomerMp;

import java.util.List;
import java.util.Optional;

public interface WsUserCustomerMpDao {

    Optional<WsUserCustomerMp> selectById(long customerId);

    Optional<List<WsUserCustomerMp>> getId(long customerId);

    int update(WsUserCustomerMp wcm);

    int del(long id);

    List<String[]> getUser(long customerId);

    int insert(WsUserCustomerMp wcm);

    String selectCustomerId();

    String selectUserId();

    Optional<WsUserCustomerMp> selectByUserId(long userid);

    Optional<List<WsUserCustomerMp>> getCustomer(long customerId);

    Optional<List<WsUserCustomerMp>> selectByCustomerIds(List<Long> customerIds);
}
