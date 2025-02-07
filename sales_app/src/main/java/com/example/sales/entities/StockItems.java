package com.example.sales.entities;

import com.example.sales.dto.InvoiceLineDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "StockItems", schema = "Warehouse")
@Getter
@Setter
@NoArgsConstructor
public class StockItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StockItemID")
    private Long stockItemId;

    @Column(name = "StockItemName")
    private String stockItemName;

    @JsonManagedReference("stockItemsInvoice")
    @OneToMany(mappedBy = "stockItems", fetch = FetchType.LAZY)
    private List<InvoiceLine> invoiceLines = new ArrayList<>();
}
