package com.example.sales.services;

import com.example.sales.dto.CustomerDTO;
import com.example.sales.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable).map(CustomerDTO::new);
    }
}
