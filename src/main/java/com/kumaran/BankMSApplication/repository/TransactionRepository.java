package com.kumaran.BankMSApplication.repository;

import com.kumaran.BankMSApplication.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
