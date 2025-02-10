package com.example.sales.dto;

import com.example.sales.entities.Invoice;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class InvoiceDTO {
    private Long invoiceId;
    private LocalDate invoiceDate;
    private List<InvoiceLineDTO> invoiceLines;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CustomerDTO customer;

    public InvoiceDTO(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.invoiceDate = invoice.getInvoiceDate();
        this.invoiceLines = invoice.getInvoiceLines().stream()
                .map(InvoiceLineDTO::new)
                .toList();
    }
}
