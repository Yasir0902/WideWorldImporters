package com.example.sales.services;

import com.example.sales.dto.CustomerDTO;
import com.example.sales.dto.OrderDTO;
import com.example.sales.dto.OrderFullDetailsDTO;
import com.example.sales.entities.Order;
import com.example.sales.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO getOrderWithOrderLines(Long orderId) {
        Order order = orderRepository.findByIdWithOrderLines(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderDTO(order);
    }

    public Page<OrderDTO> getAllOrders(int page, int size) {
        return orderRepository.findAll(PageRequest.of(page, size))
                .map(OrderDTO::new);
    }

    @Transactional(readOnly = true)
    public List<OrderFullDetailsDTO> getAllOrderDetails(Pageable pageable){
        Page<Order> order = orderRepository.findAll(pageable);
        return order.stream()
                .map(OrderFullDetailsDTO::new)
                .collect(Collectors.toList());
    }

    public List<OrderFullDetailsDTO> getOrdersById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No orders found"));
        return List.of(new OrderFullDetailsDTO(order));
    }
}
