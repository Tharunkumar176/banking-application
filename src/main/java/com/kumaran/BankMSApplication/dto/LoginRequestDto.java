package com.kumaran.BankMSApplication.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}