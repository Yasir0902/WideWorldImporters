package com.example.sales.dto;

import com.example.sales.entities.StockItems;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StockItemsDTO {

    private Long stockItemId;
    private String stockItemName;
    @JsonIgnoreProperties(value = {"stockItemId", "invoice"})
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<InvoiceLineDTO> invoiceLines;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ShortInvoiceDTO> invoices;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ShortCustomerDTO> customers;

    public StockItemsDTO(StockItems stockItems) {
        this.stockItemId = stockItems.getStockItemId();
        this.stockItemName = stockItems.getStockItemName();
    }
}
