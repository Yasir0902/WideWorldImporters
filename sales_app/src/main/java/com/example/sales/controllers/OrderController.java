package com.example.sales.controllers;

import com.example.sales.dto.OrderDTO;
import com.example.sales.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public OrderDTO getOrderWithOrderLines(@PathVariable Long orderId) {
        return orderService.getOrderWithOrderLines(orderId);
    }
}
