package com.example.sales.services;

import com.example.sales.dto.CustomerDTO;
import com.example.sales.entities.Customer;
import com.example.sales.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable).map(CustomerDTO::new);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return new CustomerDTO(customer);
    }

    public CustomerDTO getCustomerWithOrders(Long customerId) {
        Customer customer = customerRepository.findCustomerWithOrders(customerId)
                .orElseThrow(() -> new RuntimeException(""));
        return new CustomerDTO(customer);
    }

    public List<CustomerDTO> getAllCustomersWithFullHierarchy(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }


    public List<CustomerDTO> getSpecificCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return List.of(new CustomerDTO(customer));
    }

}
