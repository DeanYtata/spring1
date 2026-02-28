package com.reto.catalog;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_ORDERS = "orders-queue";

    @Bean
    public Queue ordersQueue() {
        return new Queue(QUEUE_ORDERS, true);
    }
}