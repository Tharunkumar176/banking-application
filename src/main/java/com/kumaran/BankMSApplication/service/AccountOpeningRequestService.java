package com.kumaran.BankMSApplication.service;

import com.kumaran.BankMSApplication.dto.AccountOpeningRequestDto;

public interface AccountOpeningRequestService {

    String submitRequest(
            AccountOpeningRequestDto dto,
            String customerEmail);
}