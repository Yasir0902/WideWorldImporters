package com.example.sales.controllers;

import com.example.sales.dto.CustomerDTO;
import com.example.sales.entities.Customer;
import com.example.sales.repositories.CustomerRepository;
import com.example.sales.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Page<CustomerDTO> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return customerService.getAllCustomers(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/{customerId}/orders")
    public CustomerDTO getCustomerWithOrders(@PathVariable Long customerId) {
        return customerService.getCustomerWithOrders(customerId);
    }
}
