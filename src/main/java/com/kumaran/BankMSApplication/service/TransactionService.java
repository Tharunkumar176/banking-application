package com.kumaran.BankMSApplication.service;

import com.kumaran.BankMSApplication.dto.TransactionRequestDto;
import com.kumaran.BankMSApplication.dto.TransferRequestDto;
import com.kumaran.BankMSApplication.entity.Transaction;

import java.util.List;

public interface TransactionService {

    String deposit(TransactionRequestDto dto);

    String withdraw(TransactionRequestDto dto);

    String transfer(TransferRequestDto dto);

    List<Transaction> getTransactions(String accountNumber);

    Double checkBalance(String accountNumber);
}