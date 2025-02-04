package com.example.sales.services;

import com.example.sales.dto.InvoiceDTO;
import com.example.sales.entities.Invoice;
import com.example.sales.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceDTO getInvoiceWithLines(Long invoiceId) {
        Invoice invoice = invoiceRepository.findByIdWithInvoiceLines(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        return new InvoiceDTO(invoice);
    }

    public Page<InvoiceDTO> getAllInvoices(int page, int size) {
        return invoiceRepository.findAll(PageRequest.of(page, size))
                .map(InvoiceDTO::new);
    }
}
