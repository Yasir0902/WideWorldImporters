package com.example.sales.dto;

import com.example.sales.entities.Invoice;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class InvoiceDTO {
    private Long invoiceId;
    private LocalDate invoiceDate;
    private List<InvoiceLineDTO> invoiceLines;

    public InvoiceDTO(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.invoiceDate = invoice.getInvoiceDate();
        this.invoiceLines = invoice.getInvoiceLines().stream()
                .map(InvoiceLineDTO::new)
                .collect(Collectors.toList());
    }
}
