package com.example.sales.services;

import com.example.sales.dto.OrderFullDetailsDTO;
import com.example.sales.entities.Order;
import com.example.sales.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderFullDetailsDTO> getAllOrders(Pageable pageable) {
        Page<Order> order = orderRepository.findAll(pageable);
        return order.stream()
                .map(OrderFullDetailsDTO::new)
                .collect(Collectors.toList());
    }

    public List<OrderFullDetailsDTO> getOrdersById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No orders found"));
        return List.of(new OrderFullDetailsDTO(order));
    }
}
