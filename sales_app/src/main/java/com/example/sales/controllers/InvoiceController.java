package com.example.sales.controllers;

import com.example.sales.dto.InvoiceDTO;
import com.example.sales.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{invoiceId}")
    public InvoiceDTO getInvoiceWithLines(@PathVariable Long invoiceId) {
        return invoiceService.getInvoiceWithLines(invoiceId);
    }

    @GetMapping
    public Page<InvoiceDTO> getAllInvoices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return invoiceService.getAllInvoices(page, size);
    }
}
