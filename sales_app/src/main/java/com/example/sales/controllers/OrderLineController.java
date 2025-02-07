package com.example.sales.controllers;

import com.example.sales.dto.OrderLineFullDetailsDTO;
import com.example.sales.entities.OrderLine;
import com.example.sales.services.OrderLineService;
import com.example.sales.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @GetMapping("/all")
    public List<OrderLineFullDetailsDTO> getAllProducts(
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){

        Pageable pageable = PageRequest.of(page,size);

        return orderLineService.getAllProducts(pageable);
    }
}
