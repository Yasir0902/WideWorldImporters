package com.example.sales.dto;

import com.example.sales.entities.Customer;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private CustomerCategoryDTO category;
    private BuyingGroupDTO buyingGroup;
    private List<OrderDTO> orders;
    private List<InvoiceDTO> invoices;

    public CustomerDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.customerName = customer.getCustomerName();
        this.category = new CustomerCategoryDTO(customer.getCustomerCategory());
        this.buyingGroup = new BuyingGroupDTO(customer.getBuyingGroup());
        this.orders = customer.getOrders().stream()
                .map(OrderDTO::new)
                .toList();
        this.invoices = customer.getInvoices().stream().map(InvoiceDTO::new).toList();
    }
}
