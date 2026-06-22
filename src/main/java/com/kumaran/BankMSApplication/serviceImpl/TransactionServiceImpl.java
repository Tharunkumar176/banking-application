package com.kumaran.BankMSApplication.serviceImpl;

import com.kumaran.BankMSApplication.dto.TransactionRequestDto;
import com.kumaran.BankMSApplication.dto.TransferRequestDto;
import com.kumaran.BankMSApplication.entity.Account;
import com.kumaran.BankMSApplication.entity.Transaction;
import com.kumaran.BankMSApplication.enums.TransactionType;
import com.kumaran.BankMSApplication.repository.AccountRepository;
import com.kumaran.BankMSApplication.repository.TransactionRepository;
import com.kumaran.BankMSApplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl
        implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public String deposit(TransactionRequestDto dto) {

        Account account = accountRepository
                .findByAccountNumber(dto.getAccountNumber())
                .orElseThrow(() ->
                        new RuntimeException("Account Not Found"));

        account.setBalance(
                account.getBalance() + dto.getAmount()
        );

        accountRepository.save(account);

        Transaction transaction = new Transaction();

        transaction.setAmount(dto.getAmount());

        transaction.setTransactionType(
                TransactionType.DEPOSIT
        );

        transaction.setTransactionTime(
                LocalDateTime.now()
        );

        transaction.setRemarks("Cash Deposit");

        transaction.setReceiverAccount(account);

        transactionRepository.save(transaction);

        return "Amount Deposited Successfully";
    }

    @Override
    public String withdraw(TransactionRequestDto dto) {

        Account account = accountRepository
                .findByAccountNumber(dto.getAccountNumber())
                .orElseThrow(() ->
                        new RuntimeException("Account Not Found"));

        if(account.getBalance() < dto.getAmount()){
            throw new RuntimeException("Insufficient Balance");
        }

        account.setBalance(
                account.getBalance() - dto.getAmount()
        );

        accountRepository.save(account);

        Transaction transaction = new Transaction();

        transaction.setAmount(dto.getAmount());

        transaction.setTransactionType(
                TransactionType.WITHDRAW
        );

        transaction.setTransactionTime(
                LocalDateTime.now()
        );

        transaction.setRemarks("Cash Withdrawal");

        transaction.setSenderAccount(account);

        transactionRepository.save(transaction);

        return "Amount Withdrawn Successfully";
    }

    @Override
    public String transfer(TransferRequestDto dto) {

        Account sender = accountRepository
                .findByAccountNumber(dto.getSenderAccountNumber())
                .orElseThrow(() ->
                        new RuntimeException("Sender Not Found"));

        Account receiver = accountRepository
                .findByAccountNumber(dto.getReceiverAccountNumber())
                .orElseThrow(() ->
                        new RuntimeException("Receiver Not Found"));

        if(sender.getBalance() < dto.getAmount()){
            throw new RuntimeException("Insufficient Balance");
        }

        sender.setBalance(
                sender.getBalance() - dto.getAmount()
        );

        receiver.setBalance(
                receiver.getBalance() + dto.getAmount()
        );

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transaction transaction = new Transaction();

        transaction.setAmount(dto.getAmount());

        transaction.setTransactionType(
                TransactionType.TRANSFER
        );

        transaction.setTransactionTime(
                LocalDateTime.now()
        );

        transaction.setRemarks("Account Transfer");

        transaction.setSenderAccount(sender);

        transaction.setReceiverAccount(receiver);

        transactionRepository.save(transaction);

        return "Transfer Successful";
    }

    @Override
    public List<Transaction> getTransactions(
            String accountNumber) {

        Account account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new RuntimeException("Account Not Found"));

        return transactionRepository
                .findBySenderAccount(account);
    }

    @Override
    public Double checkBalance(String accountNumber) {

        Account account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new RuntimeException("Account Not Found"));

        return account.getBalance();
    }
}