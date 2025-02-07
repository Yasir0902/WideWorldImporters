package com.example.sales.services;

import com.example.sales.dto.OrderLineFullDetailsDTO;
import com.example.sales.entities.OrderLine;
import com.example.sales.repositories.OrderLineRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    public List<OrderLineFullDetailsDTO> getAllProducts(Pageable pageable){

        Page<OrderLine> allProducts = orderLineRepository.findAll(pageable);

        return allProducts.stream()
                .map(OrderLineFullDetailsDTO::new)
                .collect(Collectors.toList());
    }
}
