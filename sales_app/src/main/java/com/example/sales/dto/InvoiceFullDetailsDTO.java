package com.example.sales.dto;

import com.example.sales.entities.Invoice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class InvoiceFullDetailsDTO {
    private Long invoiceId;
    private LocalDate invoiceDate;
    private List<InvoiceLineDTO> invoiceLines;
    @JsonIgnoreProperties(value = {"orders", "invoices", "transactions", "category", "buyingGroup"})
    private CustomerDTO customer;
    @JsonIgnoreProperties(value = {"orderInvoice"})
    private OrderDTO order;
    private List<CustomerTransactionDTO> customerTransactions;

    public InvoiceFullDetailsDTO(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.invoiceDate = invoice.getInvoiceDate();
        this.invoiceLines = invoice.getInvoiceLines().stream()
                .map(InvoiceLineDTO::new)
                .toList();
        this.customer = new CustomerDTO(invoice.getCustomer());
        this.order = new OrderDTO(invoice.getOrder());
        this.customerTransactions = invoice.getCustomer().getTransactions().stream()
                .map(CustomerTransactionDTO::new)
                .toList();
    }
}
