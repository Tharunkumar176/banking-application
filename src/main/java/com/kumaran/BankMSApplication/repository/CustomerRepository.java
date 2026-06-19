package com.kumaran.BankMSApplication.repository;

import com.kumaran.BankMSApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
