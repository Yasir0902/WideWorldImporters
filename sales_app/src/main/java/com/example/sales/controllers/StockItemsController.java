package com.example.sales.controllers;

import com.example.sales.dto.StockItemsDTO;
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
    public List<StockItemsDTO> getAllStocks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "false") Boolean invoiceLines,
            @RequestParam(required = false, defaultValue = "false") Boolean invoices,
            @RequestParam(required = false, defaultValue = "false") Boolean customers
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("stockItemId").ascending());
        if (id == null) {
            return stockItemsService.getAllStockItems(pageable, invoiceLines, invoices, customers);
        } else {
            return stockItemsService.getAllStockItemsById(pageable, id, invoiceLines, invoices, customers);
        }
    }
}
