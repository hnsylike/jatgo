package com.kafang.atgo.transport.rabbitmq;

import io.ffreedom.common.group.BaseGroup;
import io.ffreedom.transport.base.role.Publisher;
import io.ffreedom.transport.rabbitmq.RabbitMqPublisher;
import io.ffreedom.transport.rabbitmq.config.RmqPublisherConfigurator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PublisherPool extends BaseGroup<PublisherKey, Publisher<byte[]>> {

    public final static PublisherPool INSTANCE = new PublisherPool();

    private PublisherPool() {

    }

    @Override
    protected Publisher<byte[]> createMember(PublisherKey key) {
        log.debug("createMember for -> " + key.getTag());
        Publisher<byte[]> publisher = new RabbitMqPublisher(key.getTag(),
                RmqPublisherConfigurator.configuration().setConnectionParam(key.getHost(), key.getPort())
                        .setUserParam(key.getUsername(), key.getPassword())
                        .setModeFanoutAndBindQueues(key.getExchange(), key.getQueues()));
        return publisher;
    }

    public static void main(String[] args) {



    }

}
