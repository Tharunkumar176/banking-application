package com.kumaran.BankMSApplication.serviceImpl;

import com.kumaran.BankMSApplication.dto.AccountOpeningRequestDto;
import com.kumaran.BankMSApplication.entity.AccountOpeningRequest;
import com.kumaran.BankMSApplication.entity.Bank;
import com.kumaran.BankMSApplication.entity.User;
import com.kumaran.BankMSApplication.enums.RequestStatus;
import com.kumaran.BankMSApplication.repository.AccountOpeningRequestRepository;
import com.kumaran.BankMSApplication.repository.BankRepository;
import com.kumaran.BankMSApplication.repository.UserRepository;
import com.kumaran.BankMSApplication.service.AccountOpeningRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountOpeningRequestServiceImpl
        implements AccountOpeningRequestService {

    private final AccountOpeningRequestRepository requestRepository;
    private final UserRepository userRepository;
    private final BankRepository bankRepository;

    @Override
    public String submitRequest(
            AccountOpeningRequestDto dto,
            String customerEmail) {

        User user = userRepository
                .findByEmail(customerEmail)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        Bank bank = bankRepository
                .findById(dto.getBankId())
                .orElseThrow(() ->
                        new RuntimeException("Bank Not Found"));

        AccountOpeningRequest request =
                new AccountOpeningRequest();

        request.setCustomerName(dto.getCustomerName());

        request.setMobileNumber(dto.getMobileNumber());

        request.setGender(dto.getGender());

        request.setAddress(dto.getAddress());

        request.setAccountType(dto.getAccountType());

        /*request.setAadhaarFileName(
                aadhaarFile.getOriginalFilename()
        );*/

        request.setRequestStatus(
                RequestStatus.PENDING
        );

        request.setBank(bank);

        request.setUser(user);

        requestRepository.save(request);

        return "Account Opening Request Submitted Successfully";
    }
}