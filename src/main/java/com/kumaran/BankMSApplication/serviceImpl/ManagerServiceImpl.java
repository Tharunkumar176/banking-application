package com.kumaran.BankMSApplication.serviceImpl;

import com.kumaran.BankMSApplication.entity.*;
import com.kumaran.BankMSApplication.enums.AccountStatus;
import com.kumaran.BankMSApplication.enums.CustomerStatus;
import com.kumaran.BankMSApplication.enums.RequestStatus;
import com.kumaran.BankMSApplication.repository.*;
import com.kumaran.BankMSApplication.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final AccountOpeningRequestRepository requestRepository;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Override
    public List<AccountOpeningRequest> getPendingRequests() {

        return requestRepository.findByRequestStatus(
                RequestStatus.PENDING
        );
    }

    @Override
    public String approveRequest(Long requestId) {

        AccountOpeningRequest request =
                requestRepository.findById(requestId)
                        .orElseThrow(() ->
                                new RuntimeException("Request Not Found"));

        if(request.getRequestStatus() == RequestStatus.APPROVED){
            return "Request Already Approved";
        }

        Customer customer = new Customer();

        customer.setCustomerName(
                request.getCustomerName()
        );

        customer.setMobileNumber(
                request.getMobileNumber()
        );



        customer.setStatus(
                CustomerStatus.ACTIVE
        );

        customer.setBank(
                request.getBank()
        );

        customerRepository.save(customer);

        Account account = new Account();

        account.setAccountNumber(
                generateAccountNumber()
        );

        account.setBalance(0.0);

        account.setOpeningDate(
                LocalDate.now()
        );

        account.setAccountType(
                request.getAccountType()
        );

        account.setAccountStatus(
                AccountStatus.ACTIVE
        );

        account.setCustomer(customer);

        account.setBank(
                request.getBank()
        );

        accountRepository.save(account);

        request.setRequestStatus(
                RequestStatus.APPROVED
        );

        requestRepository.save(request);

        return "Account Approved Successfully";
    }

    private String generateAccountNumber(){

        return "ACC" + System.currentTimeMillis();
    }
}