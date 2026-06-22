package com.kumaran.BankMSApplication.controllers;


import com.kumaran.BankMSApplication.entity.AccountOpeningRequest;
import com.kumaran.BankMSApplication.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/requests")
    public List<AccountOpeningRequest> getPendingRequests(){

        return managerService.getPendingRequests();
    }

    @PostMapping("/approve/{requestId}")
    public String approveRequest(
            @PathVariable Long requestId){

        return managerService.approveRequest(
                requestId
        );
    }
}
