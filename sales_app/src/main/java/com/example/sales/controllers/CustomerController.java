package com.example.sales.controllers;

import com.example.sales.dto.CustomerDTO;
import com.example.sales.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/details")
    public List<CustomerDTO> getAllCustomersWithFullDetails(
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (id != null) {
            return customerService.getCustomerById(id);
        }
        Pageable pageable = PageRequest.of(page, size);
        return customerService.getAllCustomers(pageable);
    }
}
