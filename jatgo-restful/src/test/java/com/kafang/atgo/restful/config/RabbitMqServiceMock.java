package com.kafang.atgo.restful.config;

import com.kafang.atgo.bean.fix.FixCancelOrder;
import com.kafang.atgo.bean.fix.FixOrder;
import com.kafang.atgo.restful.service.RabbitMQService;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xuejian.sun
 * @date ${Date}
 */
@Slf4j
//@Component
//@Primary
public class RabbitMqServiceMock extends RabbitMQService {

    private List<FixOrder> fixOrders = new LinkedList<>();
    private List<FixCancelOrder> cancelOrders = new LinkedList<>();

    @Override
    public void init() {
        //
        log.info("initialize mock RabbitMQService");
    }

    @Override
    public void sendNewOrder(FixOrder order) {
        fixOrders.add(order);
    }

    @Override
    public void sendCancelOrder(FixCancelOrder order) {
        cancelOrders.add(order);
    }
}
