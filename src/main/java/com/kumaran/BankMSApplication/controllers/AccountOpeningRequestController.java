package com.kumaran.BankMSApplication.controllers;

import com.kumaran.BankMSApplication.dto.AccountOpeningRequestDto;
import com.kumaran.BankMSApplication.service.AccountOpeningRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class AccountOpeningRequestController {

    private final AccountOpeningRequestService service;

    @PostMapping("/account-opening")
    public String submitRequest(
            @RequestBody AccountOpeningRequestDto dto,
            @RequestParam String email){

        return service.submitRequest(dto, email);
    }
}