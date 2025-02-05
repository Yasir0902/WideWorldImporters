package com.example.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OrderLines", schema = "Sales")
@Getter
@Setter
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderLineID")
    private Long orderLineId;

    @ManyToOne
    @JoinColumn(name = "OrderID", nullable = false)
    private Order order;

    @Column(name = "Quantity")
    private Integer quantity;
}
