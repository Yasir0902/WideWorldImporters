package com.example.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CustomerCategories", schema = "Sales")
@Getter
@Setter
public class CustomerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerCategoryID")
    private Long customerCategoryId;

    @Column(name = "CustomerCategoryName")
    private String customerCategoryName;

    @Column(name = "LastEditedBy")
    private Integer lastEditedBy;

    @Column(name = "ValidFrom")
    private LocalDateTime validFrom;

    @Column(name = "ValidTo")
    private LocalDateTime validTo;

    @OneToMany(mappedBy = "customerCategory")
    private List<Customer> customers;
}
