package com.kumaran.BankMSApplication.repository;

import com.kumaran.BankMSApplication.entity.BankManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankManagerRepository extends JpaRepository<BankManager, Long> {
}
