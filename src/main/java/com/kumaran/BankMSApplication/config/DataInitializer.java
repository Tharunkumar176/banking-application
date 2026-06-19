package com.kumaran.BankMSApplication.config;

import com.kumaran.BankMSApplication.entity.Bank;
import com.kumaran.BankMSApplication.entity.BankManager;
import com.kumaran.BankMSApplication.entity.User;
import com.kumaran.BankMSApplication.enums.Role;
import com.kumaran.BankMSApplication.repository.BankManagerRepository;
import com.kumaran.BankMSApplication.repository.BankRepository;
import com.kumaran.BankMSApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BankRepository bankRepository;
    private final BankManagerRepository bankManagerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        createHdfcBank();

        createSbiBank();
    }

    private void createHdfcBank() {

        if(bankRepository.findByBankName("HDFC").isPresent()) {
            return;
        }

        Bank bank = new Bank();

        bank.setBankName("HDFC");
        bank.setIfscCode("HDFC0001");
        bank.setBranchName("Hyderabad");
        bank.setAddress("Hyderabad");
        bank.setActive(true);

        bankRepository.save(bank);

        User managerUser = new User();

        managerUser.setFullName("HDFC Manager");
        managerUser.setEmail("hdfcmanager@gmail.com");
        managerUser.setPassword(
                passwordEncoder.encode("hdfc123")
        );
        managerUser.setRole(Role.BANK_MANAGER);
        managerUser.setActive(true);

        userRepository.save(managerUser);

        BankManager manager = new BankManager();

        manager.setContactNumber("9999999999");
        manager.setActive(true);
        manager.setUser(managerUser);
        manager.setBank(bank);

        bankManagerRepository.save(manager);
    }

    private void createSbiBank() {

        if(bankRepository.findByBankName("SBI").isPresent()) {
            return;
        }

        Bank bank = new Bank();

        bank.setBankName("SBI");
        bank.setIfscCode("SBI0001");
        bank.setBranchName("Hyderabad");
        bank.setAddress("Hyderabad");
        bank.setActive(true);

        bankRepository.save(bank);

        User managerUser = new User();

        managerUser.setFullName("SBI Manager");
        managerUser.setEmail("sbimanager@gmail.com");
        managerUser.setPassword(
                passwordEncoder.encode("sbi123")
        );
        managerUser.setRole(Role.BANK_MANAGER);
        managerUser.setActive(true);

        userRepository.save(managerUser);

        BankManager manager = new BankManager();

        manager.setContactNumber("8888888888");
        manager.setActive(true);
        manager.setUser(managerUser);
        manager.setBank(bank);

        bankManagerRepository.save(manager);
    }
}