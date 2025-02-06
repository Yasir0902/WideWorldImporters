package com.example.sales.dto;

import com.example.sales.entities.Customer;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Getter
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private CustomerCategoryDTO category;
    private BuyingGroupDTO buyingGroup;
    private List<OrderDTO> orders;
    private List<InvoiceDTO> invoices;
    private List<CustomerTransactionDTO> transactions;

    public CustomerDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.customerName = customer.getCustomerName();

        this.category = Optional.ofNullable(customer.getCustomerCategory())
                .map(CustomerCategoryDTO::new)
                .orElse(null);

        this.buyingGroup = Optional.ofNullable(customer.getBuyingGroup())
                .map(BuyingGroupDTO::new)
                .orElse(null);

        this.orders = Optional.ofNullable(customer.getOrders())
                .orElse(Collections.emptyList())
                .stream()
                .map(OrderDTO::new)
                .toList();

        this.invoices = Optional.ofNullable(customer.getInvoices())
                .orElse(Collections.emptyList())
                .stream()
                .map(InvoiceDTO::new)
                .toList();

        this.transactions = Optional.ofNullable(customer.getTransactions())
                .orElse(Collections.emptyList())
                .stream()
                .map(CustomerTransactionDTO::new)
                .toList();
    }
}
