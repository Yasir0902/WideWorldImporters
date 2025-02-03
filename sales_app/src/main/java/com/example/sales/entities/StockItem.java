package com.example.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "StockItems", schema = "Warehouse")
@Getter
@Setter
public class StockItem {
    @Id
    @Column(name = "StockItemID")
    private Long stockItemId;

    @Column(name = "StockItemName")
    private String stockItemName;
}
