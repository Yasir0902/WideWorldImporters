package com.example.sales.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders", schema = "Sales")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Long orderId;

    @JsonBackReference("customer-orders")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @JsonManagedReference("order-lines")
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderLine> orderLines = new ArrayList<>();
}
