package com.example.sales.dto;

import com.example.sales.entities.Order;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class OrderDTO {
    private Long orderId;
    private LocalDate orderDate;
    private List<OrderLineDTO> orderLines;

    public OrderDTO(Order order) {
        this.orderId = order.getOrderId();
        this.orderDate = order.getOrderDate();
        this.orderLines = order.getOrderLines().stream()
                .map(OrderLineDTO::new)
                .toList();
    }
}
