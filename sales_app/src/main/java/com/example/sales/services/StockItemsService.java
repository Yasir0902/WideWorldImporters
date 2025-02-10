package com.example.sales.services;

import com.example.sales.dto.*;
import com.example.sales.entities.Invoice;
import com.example.sales.entities.InvoiceLine;
import com.example.sales.entities.StockItems;
import com.example.sales.repositories.StockItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockItemsService {

    @Autowired
    private StockItemsRepository stockItemsRepository;

    public List<StockItemsDTO> getAllStockItems(Pageable pageable, Boolean invoiceLines, Boolean invoices, Boolean customers) {

        Page<StockItems> stockItemsPage = stockItemsRepository.findAll(pageable);

        List<StockItemsDTO> stockItemsDTOFull = stockItemsPage.stream()
                .map(stockItem -> {
                    StockItemsDTO stockItemsDTO = new StockItemsDTO(stockItem);

                    if (invoiceLines) {
                        List<InvoiceLineDTO> invoiceLineDTOs = stockItem.getInvoiceLines().stream()
                                .map(InvoiceLineDTO::new)
                                .collect(Collectors.toList());
                        stockItemsDTO.setInvoiceLines(invoiceLineDTOs);
                    }

                    if (invoices) {
                        List<ShortInvoiceDTO> invoiceDTOS = stockItem.getInvoiceLines().stream()
                                .map(InvoiceLine::getInvoice)
                                .distinct()
                                .map(ShortInvoiceDTO::new)
                                .collect(Collectors.toList());
                        stockItemsDTO.setInvoices(invoiceDTOS);
                    }

                    if (customers) {
                        List<ShortCustomerDTO> customerDTOS = stockItem.getInvoiceLines().stream()
                                .map(InvoiceLine::getInvoice)
                                .filter(invoice -> invoice != null)
                                .distinct()
                                .map(Invoice::getCustomer)
                                .filter(customer -> customer != null)
                                .distinct()
                                .map(ShortCustomerDTO::new)
                                .collect(Collectors.toList());
                        stockItemsDTO.setCustomers(customerDTOS);
                    }

                    return stockItemsDTO;
                })
                .collect(Collectors.toList());

        return stockItemsDTOFull;
    }

    public List<StockItemsDTO> getAllStockItemsById(Pageable pageable,Long id, Boolean invoiceLines, Boolean invoices, Boolean customers) {

        Optional<StockItems> stockItemsPage = stockItemsRepository.findById(id);

        List<StockItemsDTO> stockItemsDTOFull = stockItemsPage.stream()
                .map(stockItem -> {
                    StockItemsDTO stockItemsDTO = new StockItemsDTO(stockItem);

                    if (invoiceLines) {
                        List<InvoiceLineDTO> invoiceLineDTOs = stockItem.getInvoiceLines().stream()
                                .map(InvoiceLineDTO::new)
                                .collect(Collectors.toList());
                        stockItemsDTO.setInvoiceLines(invoiceLineDTOs);
                    }

                    if (invoices) {
                        List<ShortInvoiceDTO> invoiceDTOS = stockItem.getInvoiceLines().stream()
                                .map(InvoiceLine::getInvoice)
                                .distinct()
                                .map(ShortInvoiceDTO::new)
                                .collect(Collectors.toList());
                        stockItemsDTO.setInvoices(invoiceDTOS);
                    }

                    if (customers) {
                        List<ShortCustomerDTO> customerDTOS = stockItem.getInvoiceLines().stream()
                                .map(InvoiceLine::getInvoice)
                                .filter(invoice -> invoice != null)
                                .distinct()
                                .map(Invoice::getCustomer)
                                .filter(customer -> customer != null)
                                .distinct()
                                .map(ShortCustomerDTO::new)
                                .collect(Collectors.toList());
                        stockItemsDTO.setCustomers(customerDTOS);
                    }

                    return stockItemsDTO;
                })
                .collect(Collectors.toList());

        return stockItemsDTOFull;
    }

}
