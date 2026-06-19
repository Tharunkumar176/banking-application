package com.kumaran.BankMSApplication.controllers;

import com.kumaran.BankMSApplication.entity.Bank;
import com.kumaran.BankMSApplication.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping
    public List<Bank> getAllBanks() {

        return bankService.getAllBanks();
    }
}