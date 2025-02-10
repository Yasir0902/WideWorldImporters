package com.example.sales.controllers;

import com.example.sales.entities.StockItems;
import com.example.sales.services.StockItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockItemsController {

    @Autowired
    private StockItemsService stockItemsService;

    @GetMapping("/all")
    public List<StockItems> getAllStocks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size,Sort.by("stockItemId").ascending());
        return stockItemsService.getAllStockItems(pageable);
    }
}
