package com.kumaran.BankMSApplication.entity;

import com.kumaran.BankMSApplication.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    private String mobileNumber;

    private String gender;

    private String aadhaarFilePath;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @ManyToOne
    private Bank bank;

    @OneToOne
    private User user;
}
