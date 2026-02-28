package com.reto.orders;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Long productId, Integer quantity) {
        String message = productId + ":" + quantity;
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_ORDERS, message);
        System.out.println("📨 Mensaje enviado a RabbitMQ: " + message);
    }
}