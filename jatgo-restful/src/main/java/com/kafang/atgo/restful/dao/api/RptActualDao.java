package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.RptActual;

import java.util.List;
import java.util.Optional;

public interface RptActualDao {

    Optional<List<RptActual>> selectByCustomer(long customerId, int strategyId, String stime, String endtime);

}
