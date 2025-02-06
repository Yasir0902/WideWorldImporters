package com.example.sales.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customers", schema = "Sales")
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(
        name = "Customer.fullHierarchy",
        attributeNodes = {
                @NamedAttributeNode("customerCategory"),
                @NamedAttributeNode("buyingGroup"),
                @NamedAttributeNode(value = "orders", subgraph = "orders-subgraph"),
                @NamedAttributeNode(value = "invoices", subgraph = "invoices-subgraph"),
                @NamedAttributeNode("transactions")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "orders-subgraph",
                        attributeNodes = @NamedAttributeNode("orderLines")
                ),
                @NamedSubgraph(
                        name = "invoices-subgraph",
                        attributeNodes = @NamedAttributeNode("invoiceLines")
                )
        }
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Long customerId;

    @Column(name = "CustomerName")
    private String customerName;

    @JsonManagedReference("customer-category")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerCategoryID")
    private CustomerCategory customerCategory;

    @JsonManagedReference("customer-buying-group")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BuyingGroupID")
    private BuyingGroup buyingGroup;

    @JsonManagedReference("customer-orders")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @JsonManagedReference("customer-invoices")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Invoice> invoices = new ArrayList<>();

    @JsonManagedReference("customer-transactions")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerTransaction> transactions = new ArrayList<>();
}
