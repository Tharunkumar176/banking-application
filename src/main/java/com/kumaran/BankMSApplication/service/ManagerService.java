package com.kumaran.BankMSApplication.service;



import com.kumaran.BankMSApplication.entity.AccountOpeningRequest;

import java.util.List;

public interface ManagerService {

    List<AccountOpeningRequest> getPendingRequests();

    String approveRequest(Long requestId);
}