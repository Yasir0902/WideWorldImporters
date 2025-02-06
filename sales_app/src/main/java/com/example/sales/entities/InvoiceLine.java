package com.example.sales.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "InvoiceLines", schema = "Sales")
@Getter
@Setter
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceLineID")
    private Long invoiceLineId;

    @JsonBackReference("invoice-lines")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "InvoiceID")
    private Invoice invoice;

    @Column(name = "StockItemID")
    private Long stockItemId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
}
