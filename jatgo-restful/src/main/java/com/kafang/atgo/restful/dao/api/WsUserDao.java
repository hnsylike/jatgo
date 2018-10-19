package com.kafang.atgo.restful.dao.api;

import com.kafang.atgo.restful.entity.WsPhone;
import com.kafang.atgo.restful.entity.WsUser;

import java.util.List;
import java.util.Optional;

public interface WsUserDao {

    // 根据用户名查找用户
    Optional<WsUser> selectByUsername(String username);

    // 查询所有用户信息
    Optional<List<WsUser>> selectAll();


    Optional<WsUser> selectById(long userId);

    int insert(WsUser wu);

    int del(long id);

    Optional<WsUser> selectByUserId(long userId);

    Optional<List<WsUser>> getUsername(String usernamae);

    String selectUserId();

    Optional<List<WsUser>> getuser(List<Long> userid);

    Optional<List<WsPhone>> getphone(List<Long> userid);

    Optional<WsUser> getid(long id);

    int update(WsUser wu);
}
