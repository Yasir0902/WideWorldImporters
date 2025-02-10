package com.example.sales.dto;

import com.example.sales.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class OrderFullDetailsDTO {
    private Long orderId;
    private LocalDate orderDate;
    private List<InvoiceDTO> orderInvoices;
    @JsonIgnoreProperties(value = {"orders", "invoices", "transactions", "category", "buyingGroup"})
    private CustomerDTO customer;
    private List<OrderLineDTO> orderLines;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CustomerTransactionDTO> customerTransactions;

    public OrderFullDetailsDTO(Order order) {
        this.orderId = order.getOrderId();
        this.orderDate = order.getOrderDate();
        this.orderInvoices = order.getInvoices().stream()
                .map(InvoiceDTO::new)
                .toList();
        this.customer = new CustomerDTO(order.getCustomer());
        this.orderLines = order.getOrderLines().stream()
                .map(OrderLineDTO::new)
                .toList();
        this.customerTransactions = order.getCustomer().getTransactions().stream()
                .map(CustomerTransactionDTO::new)
                .toList();
    }
}
