package com.example.sales.controllers;

import com.example.sales.dto.InvoiceFullDetailsDTO;
import com.example.sales.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/details")
    public List<InvoiceFullDetailsDTO> getTotalInvoices(
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (id != null) {
            return invoiceService.getInvoicesById(id);
        }
        Pageable pageable = PageRequest.of(page, size);
        return invoiceService.getAllInvoices(pageable);
    }
}
