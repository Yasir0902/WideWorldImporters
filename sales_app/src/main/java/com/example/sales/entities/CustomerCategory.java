package com.example.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CustomerCategories", schema = "Sales")
@Getter
@Setter
public class CustomerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerCategoryID")
    private Long categoryId;

    @Column(name = "CustomerCategoryName")
    private String categoryName;

    @OneToMany(mappedBy = "customerCategory", fetch = FetchType.LAZY)
    private List<Customer> customers;
}
