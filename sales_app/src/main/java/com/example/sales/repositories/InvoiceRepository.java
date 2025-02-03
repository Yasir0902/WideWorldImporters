package com.example.sales.repositories;

import com.example.sales.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("SELECT i FROM Invoice i LEFT JOIN FETCH i.invoiceLines WHERE i.invoiceId = :invoiceId")
    Optional<Invoice> findByIdWithInvoiceLines(@Param("invoiceId") Long invoiceId);
}
