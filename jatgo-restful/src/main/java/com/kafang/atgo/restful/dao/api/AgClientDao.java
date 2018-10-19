package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.AgClient;

import java.util.List;
import java.util.Optional;

public interface AgClientDao {

    //根据customerID查询数据
    Optional<AgClient> selectById(long customerId);

    Optional<List<AgClient>> selectByCustomer(long customerId);

    Optional<List<AgClient>> selectByClientId(List<Integer> list);

    int insert(AgClient agClient);

    String selectid();

    int del(long id);

}
