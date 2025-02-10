package com.example.sales.dto;

import com.example.sales.entities.Customer;
import lombok.Getter;

@Getter
public class ShortCustomerDTO {
    private Long customerId;
    private String customerName;

    public ShortCustomerDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.customerName = customer.getCustomerName();

    }
}
