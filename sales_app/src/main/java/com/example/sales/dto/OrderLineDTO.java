package com.example.sales.dto;

import com.example.sales.entities.OrderLine;
import lombok.Getter;

@Getter
public class OrderLineDTO {
    private Long orderLineId;
    private StockItemDTO stockItem;
    private Integer quantity;

    public OrderLineDTO(OrderLine orderLine) {
        this.orderLineId = orderLine.getOrderLineId();
        this.stockItem = new StockItemDTO(orderLine.getStockItem());
        this.quantity = orderLine.getQuantity();
    }
}
