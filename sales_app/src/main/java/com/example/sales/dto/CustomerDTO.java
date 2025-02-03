package com.example.sales.dto;

import com.example.sales.entities.Customer;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private List<OrderDTO> orders;

    public CustomerDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.customerName = customer.getCustomerName();
        this.orders = customer.getOrders().stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }
}
