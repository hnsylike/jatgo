package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.AgStrategyParamL1;

import java.util.List;
import java.util.Optional;

public interface AgStrategyParamL1Dao {
    int insert(AgStrategyParamL1 agStrategyParamL1);

    int update(AgStrategyParamL1 agStrategyParamL1);

    Optional<List<AgStrategyParamL1>> selectById(int id);

    Optional<List<AgStrategyParamL1>> selectAll();


    //根据Ag_Account表字段AccountId查询
    Optional<List<AgStrategyParamL1>> selectByAccountId(List<Integer> accountId);
}
