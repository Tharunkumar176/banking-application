package com.kumaran.BankMSApplication.repository;

import com.kumaran.BankMSApplication.entity.Account;
import com.kumaran.BankMSApplication.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySenderAccount(Account account);

    List<Transaction> findByReceiverAccount(Account account);
}