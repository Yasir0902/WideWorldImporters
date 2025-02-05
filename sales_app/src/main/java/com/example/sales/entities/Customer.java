package com.example.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Customers", schema = "Sales")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Long customerId;

    @Column(name = "CustomerName")
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "CustomerCategoryID")
    private CustomerCategory customerCategory;

    @ManyToOne
    @JoinColumn(name = "BuyingGroupID")
    private BuyingGroup buyingGroup;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerTransaction> transactions;
}
