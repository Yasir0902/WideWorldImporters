package com.example.sales.dto;

import com.example.sales.entities.StockItem;
import lombok.Getter;

@Getter
public class StockItemDTO {
    private Long stockItemId;
    private String stockItemName;

    public StockItemDTO(StockItem stockItem) {
        this.stockItemId = stockItem.getStockItemId();
        this.stockItemName = stockItem.getStockItemName();
    }
}
