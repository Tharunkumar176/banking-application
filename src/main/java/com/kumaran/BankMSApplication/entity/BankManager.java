package com.kumaran.BankMSApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank_managers")
public class BankManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    private String managerName;

    private String email;

    private String password;

    @ManyToOne
    private Bank bank;

    private String contactNumber;
    private boolean active;

    public void setUser(User managerUser) {
    }
}
