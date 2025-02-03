package com.example.sales.dto;

import com.example.sales.entities.InvoiceLine;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class InvoiceLineDTO {
    private Long invoiceLineId;
    private Long stockItemId;
    private Integer quantity;
    private BigDecimal unitPrice;

    public InvoiceLineDTO(InvoiceLine invoiceLine) {
        this.invoiceLineId = invoiceLine.getInvoiceLineId();
        this.stockItemId = invoiceLine.getStockItemId();
        this.quantity = invoiceLine.getQuantity();
        this.unitPrice = invoiceLine.getUnitPrice();
    }
}
