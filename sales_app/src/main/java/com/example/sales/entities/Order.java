package com.example.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customer;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderLine> orderLines;
}
