package com.example.sales.dto;

import com.example.sales.entities.Order;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class OrderFullDetailsDTO {
    private Long orderId;
    private LocalDate orderDate;
    private CustomerDTO customer;
    private List<OrderLineDTO> orderLines;
    private List<CustomerTransactionDTO> customerTransactions;

    public OrderFullDetailsDTO(Order order) {
        this.orderId = order.getOrderId();
        this.orderDate = order.getOrderDate();
        this.customer = new CustomerDTO(order.getCustomer());
        this.orderLines = order.getOrderLines().stream()
                .map(OrderLineDTO::new)
                .toList();
        this.customerTransactions = order.getCustomer().getTransactions().stream()
                .map(CustomerTransactionDTO::new)
                .toList();
    }
}
