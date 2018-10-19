package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.AgStrategyParamL3;

import java.util.List;
import java.util.Optional;

public interface AgStrategyParamL3Dao {
    int insert(AgStrategyParamL3 agStrategyParamL3);

    int update(AgStrategyParamL3 agStrategyParamL3);

    Optional<List<AgStrategyParamL3>> selectById(int id);

    Optional<List<AgStrategyParamL3>> selectAll();

    //根据Ag_Account表字段StrategyId查询
    Optional<List<AgStrategyParamL3>> selectByStrategyId(List<Integer> strategyId);

}
