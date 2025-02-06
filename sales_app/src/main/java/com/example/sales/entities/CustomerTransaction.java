package com.example.sales.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CustomerTransactions", schema = "Sales")
@Getter
@Setter
public class CustomerTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerTransactionID")
    private Long transactionId;

    @JsonBackReference("customer-transactions")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @JsonBackReference("invoice-transactions")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "InvoiceID")
    private Invoice invoice;

    @Column(name = "TransactionDate")
    private LocalDate transactionDate;

    @Column(name = "AmountExcludingTax")
    private BigDecimal amount;

    @Column(name = "TaxAmount")
    private BigDecimal taxAmount;
}
