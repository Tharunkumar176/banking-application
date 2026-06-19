package com.kumaran.BankMSApplication.dto;

import com.kumaran.BankMSApplication.enums.AccountType;
import lombok.Data;

@Data
public class AccountOpeningRequestDto {

    private String customerName;

    private String mobileNumber;

    private String gender;

    private String address;

    private Long bankId;

    private AccountType accountType;
}