package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.WsPhone;

import java.util.Optional;

public interface WsPhoenDao {

    Optional<WsPhone> selectByPhone(String phone);


    int insert(WsPhone wp);

    int del(long id);

    Optional<WsPhone> selectByUserId(long userId);
}
