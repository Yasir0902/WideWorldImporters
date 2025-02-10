package com.example.sales.dto;

import com.example.sales.entities.Invoice;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ShortInvoiceDTO {
    private Long invoiceId;
    private LocalDate invoiceDate;

    public ShortInvoiceDTO(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.invoiceDate = invoice.getInvoiceDate();
    }
}
