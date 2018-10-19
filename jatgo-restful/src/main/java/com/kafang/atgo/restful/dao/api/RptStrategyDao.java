package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.RptStrategy;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RptStrategyDao {

    Optional<List<RptStrategy>> selectByCustomer(long customerId, int strategyId, Date stime, Date endtime);

}
