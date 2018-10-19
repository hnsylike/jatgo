package com.kafang.atgo.persistence.db.dao.api;

import com.kafang.atgo.persistence.db.entity.AgAccount;

import java.util.List;
import java.util.Optional;

public interface AgAccountDao {

    int insert(AgAccount agAccount);

    int update(AgAccount agAccount);

    Optional<AgAccount> selectById(int strategyID);

    Optional<List<AgAccount>> selectAll();

    //根据StrategyId查询数据
    Optional<List<AgAccount>> selectByStrategyId(int StrategyId);

    //根据AccountId查询数据
    Optional<AgAccount> selectByAccountId(long AccountId);

    //根据clientId查询数据
    Optional<List<AgAccount>> selectByClientId(long clientId);

    public String selectid();

    Optional<AgAccount> selectByClient(long Clientid);

    int del(long id);
}
