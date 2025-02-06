package com.example.sales.controllers;

import com.example.sales.dto.OrderFullDetailsDTO;
import com.example.sales.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/details")
    public List<OrderFullDetailsDTO> getAllOrderDetails(
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (id != null) {
            return orderService.getOrdersById(id);
        }
        Pageable pageable = PageRequest.of(page, size);
        return orderService.getAllOrders(pageable);
    }
}
