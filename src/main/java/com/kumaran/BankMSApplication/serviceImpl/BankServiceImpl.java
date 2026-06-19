package com.kumaran.BankMSApplication.serviceImpl;

import com.kumaran.BankMSApplication.entity.Bank;
import com.kumaran.BankMSApplication.repository.BankRepository;
import com.kumaran.BankMSApplication.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Override
    public List<Bank> getAllBanks() {

        return bankRepository.findAll();
    }
}