package com.example.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "CustomerTransactions", schema = "Sales")
@Getter
@Setter
public class CustomerTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerTransactionID")
    private Long customerTransactionId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "InvoiceID", referencedColumnName = "InvoiceID")
    private Invoice invoice;

    @Column(name = "TransactionDate")
    private LocalDateTime transactionDate;

    @Column(name = "AmountExcludingTax")
    private Double amountExcludingTax;

    @Column(name = "TaxAmount")
    private Double taxAmount;

    @Column(name = "TransactionAmount")
    private Double transactionAmount;

    @Column(name = "OutstandingBalance")
    private Double outstandingBalance;

    @Column(name = "FinalizationDate")
    private LocalDateTime finalizationDate;

    @Column(name = "IsFinalized")
    private Boolean isFinalized;

    @Column(name = "LastEditedBy")
    private Integer lastEditedBy;

    @Column(name = "LastEditedWhen")
    private LocalDateTime lastEditedWhen;
}
