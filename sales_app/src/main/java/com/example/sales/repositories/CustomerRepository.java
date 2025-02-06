package com.example.sales.repositories;

import com.example.sales.entities.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.orders WHERE c.customerId = :customerId")
    Optional<Customer> findCustomerWithOrders(@Param("customerId") Long customerId);
}
