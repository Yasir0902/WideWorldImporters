package com.example.sales.dto;

import com.example.sales.entities.InvoiceLine;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class InvoiceLineDTO {
    private Long invoiceLineId;
    private Long stockItemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private InvoiceDTO invoice;

    public InvoiceLineDTO(InvoiceLine invoiceLine) {
        this.invoiceLineId = invoiceLine.getInvoiceLineId();
        this.stockItemId = invoiceLine.getStockItems().getStockItemId();
        this.quantity = invoiceLine.getQuantity();
        this.unitPrice = invoiceLine.getUnitPrice();
    }
}
