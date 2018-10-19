package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.AgCustomer;

import java.util.List;
import java.util.Optional;

public interface AgCustomerDao {
    Optional<AgCustomer> selectById(long customerId);

    Optional<AgCustomer> selectId(long id);

    Optional<List<AgCustomer>> selectAll();

    int insert(AgCustomer ac);

    Optional<AgCustomer> selectByCustomer(String customerName);

    String selectCustomerId();

    Optional<List<AgCustomer>> selectByCustomerName(String customerName);

    int del(long id);
}
