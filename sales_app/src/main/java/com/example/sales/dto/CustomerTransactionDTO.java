package com.example.sales.dto;

import com.example.sales.entities.CustomerTransaction;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class CustomerTransactionDTO {
    private Long transactionId;
    private LocalDate transactionDate;
    private BigDecimal amount;
    private BigDecimal taxAmount;

    public CustomerTransactionDTO(CustomerTransaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.transactionDate = transaction.getTransactionDate();
        this.amount = transaction.getAmount();
        this.taxAmount = transaction.getTaxAmount();
    }
}
