package com.example.sales.dto;

import com.example.sales.entities.OrderLine;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderLineDTO {
    private Long orderLineId;
    private Long stockItemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private String description;

    public OrderLineDTO(OrderLine orderLine) {
        this.orderLineId = orderLine.getOrderLineId();
        this.stockItemId = orderLine.getStockItemId();
        this.quantity = orderLine.getQuantity();
        this.unitPrice = orderLine.getUnitPrice();
        this.description = orderLine.getDescription();
    }
}
