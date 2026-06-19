package com.kumaran.BankMSApplication.mapper;

import com.kumaran.BankMSApplication.dto.BankDto;
import com.kumaran.BankMSApplication.entity.Bank;

public class BankMapper {

    public static Bank toEntity(BankDto dto){

        Bank bank = new Bank();

        bank.setBankName(dto.getBankName());
        bank.setIfscCode(dto.getIfscCode());
        bank.setBranchName(dto.getBranchName());

        return bank;
    }

    public static BankDto toDto(Bank bank){

        BankDto dto = new BankDto();

        dto.setBankName(bank.getBankName());
        dto.setIfscCode(bank.getIfscCode());
        dto.setBranchName(bank.getBranchName());

        return dto;
    }
}