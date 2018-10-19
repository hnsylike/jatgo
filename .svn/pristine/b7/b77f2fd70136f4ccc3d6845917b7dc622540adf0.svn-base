package com.kafang.atgo.restful.dao.api;


import com.kafang.atgo.restful.entity.WsOrderIns;

import java.util.List;
import java.util.Optional;


public interface WsOrderInsDao {
    //添加母单数据
    int insert(WsOrderIns wsOrderIns);

    int update(WsOrderIns wsOrderIns);

    Optional<List<WsOrderIns>> selectAll();

    Optional<List<WsOrderIns>> selectByReview(int Clientid);

    Optional<List<WsOrderIns>> selectById(Long id);
}
