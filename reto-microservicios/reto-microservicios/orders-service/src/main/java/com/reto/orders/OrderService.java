package com.reto.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMessageProducer messageProducer;

    public Order create(OrderDTO dto) {
        Order order = new Order();
        order.setProductId(dto.getProductId());
        order.setQuantity(dto.getQuantity());
        order.setStatus("PENDING");
        Order saved = orderRepository.save(order);
        messageProducer.sendOrder(saved.getProductId(), saved.getQuantity());
        return saved;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}