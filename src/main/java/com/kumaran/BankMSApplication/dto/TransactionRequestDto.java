package com.kumaran.BankMSApplication.dto;

import lombok.Data;

@Data
public class TransactionRequestDto {

    private String accountNumber;

    private Double amount;
}