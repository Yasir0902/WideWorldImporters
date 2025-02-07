package com.example.sales.services;

import com.example.sales.entities.StockItems;
import com.example.sales.repositories.StockItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class StockItemsService {

    @Autowired
    private StockItemsRepository stockItemsRepository;

    public List<StockItems> getAllStockItems(Pageable pageable){
        Page<StockItems> st = stockItemsRepository.findAll(pageable);
        return st.stream().
                collect(Collectors.toList());
    }
}
