package com.example.sales.dto;

import com.example.sales.entities.Order;
import com.example.sales.entities.OrderLine;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderLineFullDetailsDTO {

    private String productName;
    private Long productId;
    @JsonIgnoreProperties(value = {"orderLines"})
    private OrderDTO order;
    private Long stockItemId;
    private Integer quantity;
    private BigDecimal unitPrice;

    public OrderLineFullDetailsDTO(OrderLine orderLine) {

        this.productName = orderLine.getDescription();
        this.productId = orderLine.getOrderLineId();
        this.order = new OrderDTO(orderLine.getOrder());
        this.stockItemId = orderLine.getStockItemId();
        this.quantity = orderLine.getQuantity();
        this.unitPrice = orderLine.getUnitPrice();
    }

}
