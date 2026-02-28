package com.reto.catalog;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageConsumer {

    @Autowired
    private ProductRepository productRepository;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_ORDERS)
    public void receiveOrder(String message) {
        System.out.println("📩 Mensaje recibido: " + message);
        String[] parts = message.split(":");
        Long productId = Long.parseLong(parts[0]);
        Integer quantity = Integer.parseInt(parts[1]);

        productRepository.findById(productId).ifPresent(product -> {
            product.setStock(product.getStock() - quantity);
            productRepository.save(product);
            System.out.println("✅ Stock actualizado para producto " + productId + " → nuevo stock: " + product.getStock());
        });
    }
}