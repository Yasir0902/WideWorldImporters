package com.example.sales.repositories;

import com.example.sales.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
