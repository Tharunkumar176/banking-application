package com.kumaran.BankMSApplication.dto;

import lombok.Data;

@Data
public class TransferRequestDto {

    private String senderAccountNumber;

    private String receiverAccountNumber;

    private Double amount;
}