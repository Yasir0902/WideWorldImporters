package com.example.sales.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "OrderLines", schema = "Sales")
@Getter
@Setter
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderLineID")
    private Long orderLineId;

    @JsonBackReference("order-lines")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrderID")
    private Order order;

    @Column(name = "StockItemID")
    private Long stockItemId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
}
