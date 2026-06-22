package com.kumaran.BankMSApplication.controllers;

import com.kumaran.BankMSApplication.dto.TransactionRequestDto;
import com.kumaran.BankMSApplication.dto.TransferRequestDto;
import com.kumaran.BankMSApplication.entity.Transaction;
import com.kumaran.BankMSApplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/deposit")
    public String deposit(
            @RequestBody TransactionRequestDto dto){

        return transactionService.deposit(dto);
    }

    @PostMapping("/withdraw")
    public String withdraw(
            @RequestBody TransactionRequestDto dto){

        return transactionService.withdraw(dto);
    }

    @PostMapping("/transfer")
    public String transfer(
            @RequestBody TransferRequestDto dto){

        return transactionService.transfer(dto);
    }

    @GetMapping("/history/{accountNumber}")
    public List<Transaction> history(
            @PathVariable String accountNumber){

        return transactionService
                .getTransactions(accountNumber);
    }
    @GetMapping("/balance/{accountNumber}")
    public Double checkBalance(
            @PathVariable String accountNumber){

        return transactionService
                .checkBalance(accountNumber);
    }
}