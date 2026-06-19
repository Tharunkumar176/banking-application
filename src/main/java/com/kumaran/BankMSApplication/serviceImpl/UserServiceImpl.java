package com.kumaran.BankMSApplication.serviceImpl;

import com.kumaran.BankMSApplication.dto.LoginRequestDto;
import com.kumaran.BankMSApplication.dto.LoginResponseDto;
import com.kumaran.BankMSApplication.dto.UserDto;
import com.kumaran.BankMSApplication.entity.User;
import com.kumaran.BankMSApplication.enums.Role;
import com.kumaran.BankMSApplication.repository.UserRepository;
import com.kumaran.BankMSApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String registerCustomer(UserDto userDto) {

        User user = new User();

        user.setFullName(userDto.getFullName());

        user.setEmail(userDto.getEmail());

        user.setPassword(
                passwordEncoder.encode(userDto.getPassword())
        );

        user.setRole(Role.CUSTOMER);

        user.setActive(true);

        userRepository.save(user);

        return "Customer Registered Successfully";
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginDto) {

        User user = userRepository
                .findByEmail(loginDto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        if (!passwordEncoder.matches(
                loginDto.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid Credentials");
        }

        return new LoginResponseDto(
                "Login Successful",
                user.getRole().name()
        );
    }
}