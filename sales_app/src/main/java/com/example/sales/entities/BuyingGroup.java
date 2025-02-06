package com.example.sales.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "BuyingGroups", schema = "Sales")
@Getter
@Setter
public class BuyingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BuyingGroupID")
    private Long buyingGroupId;

    @Column(name = "BuyingGroupName")
    private String buyingGroupName;

    @JsonBackReference("customer-buying-group")
    @OneToMany(mappedBy = "buyingGroup", fetch = FetchType.LAZY)
    private List<Customer> customers;
}