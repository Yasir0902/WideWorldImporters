package com.example.sales.services;

import com.example.sales.dto.OrderDTO;
import com.example.sales.entities.Order;
import com.example.sales.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO getOrderWithOrderLines(Long orderId) {
        Order order = orderRepository.findByIdWithOrderLines(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderDTO(order);
    }
}
