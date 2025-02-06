package com.example.sales.repositories;

import com.example.sales.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o " +
            "LEFT JOIN FETCH o.orderLines ol " +
            "WHERE o.orderId = :orderId")
    Optional<Order> findByIdWithOrderLines(@Param("orderId") Long orderId);
}
