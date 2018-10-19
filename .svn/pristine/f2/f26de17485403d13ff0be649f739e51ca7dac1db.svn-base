package com.kafang.atgo.transport.rabbitmq;

import lombok.Getter;

@Getter
public final class PublisherKey {

    private String tag;
    private String host;
    private int port;
    private String username;
    private String password;
    private String exchange;
    private String routingKey;
    private String[] queues;

    public PublisherKey(String tag, String host, int port, String username, String password, String exchange, String routingKey, String[] queues) {
        this.tag = tag;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.queues = queues;
    }


}
