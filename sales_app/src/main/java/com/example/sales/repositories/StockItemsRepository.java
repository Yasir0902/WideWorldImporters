package com.example.sales.repositories;

import com.example.sales.entities.StockItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockItemsRepository extends JpaRepository<StockItems, Long> {
}
