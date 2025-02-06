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
@Table(name = "Invoices", schema = "Sales")
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceID")
    private Long invoiceId;

    @JsonBackReference("customer-invoices")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrderID")
    private Order order;

    @Column(name = "InvoiceDate")
    private LocalDate invoiceDate;

    @JsonManagedReference("invoice-lines")
    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<InvoiceLine> invoiceLines = new ArrayList<>();
}
