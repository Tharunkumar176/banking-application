# Banking Management System

A Banking Management System developed using:

* Backend : Spring Boot
* Frontend : React JS
* Database : MySQL
* Security : Spring Security
* ORM : Spring Data JPA (Hibernate)
* Build Tool : Maven

## Features Implemented

* Customer Registration
* Customer Login
* Bank Manager Login
* View Available Banks
* Account Opening Request
* Manager Approval Workflow
* Customer Creation
* Account Creation
* Deposit Money
* Withdraw Money
* Transfer Money
* Transaction History
* Check Account Balance
* Exception Handling
* DTO-Based Architecture
* Layered Architecture (Controller-Service-Repository)

---

# Current Project Flow

PREDEFINED BANKS

* HDFC Bank
* SBI Bank

PREDEFINED BANK MANAGERS

* HDFC Manager
* SBI Manager

FLOW

Customer Register
↓
Customer Login
↓
View Banks
↓
Select Bank
↓
Submit Account Opening Request
↓
Status = PENDING
↓
Bank Manager Reviews Request
↓
Approve Request
↓
Customer Created
↓
Account Created
↓
Account Number Generated
↓
Status = APPROVED

After Account Creation

Customer
↓
Deposit Money
↓
Withdraw Money
↓
Transfer Money
↓
Check Balance
↓
View Transaction History

---

# Project Architecture

┌─────────────────────────────┐
│       BANK MANAGER          │
└─────────────┬───────────────┘
│
├──────────────► View Pending Requests
│
├──────────────► Approve Requests
│
├──────────────► Create Customer
│
├──────────────► Create Account
│
├──────────────► Deposit Money
│
└──────────────► Withdraw Money

```
                          ▼
```

┌─────────────────────────────┐
│         CUSTOMER            │
└─────────────┬───────────────┘
│
├──────────────► Register
│
├──────────────► Login
│
├──────────────► Select Bank
│
├──────────────► Submit Account Request
│
├──────────────► Check Balance
│
├──────────────► Transfer Money
│
├──────────────► Deposit Money
│
├──────────────► Withdraw Money
│
└──────────────► View Transaction History

---

# Database Flow

USER
│
├── BANK_MANAGER
└── CUSTOMER

BANK
│
├── BANK_MANAGER
├── CUSTOMER
├── ACCOUNT
└── ACCOUNT_OPENING_REQUEST

ACCOUNT
│
└── TRANSACTION

---

# Entity Relationship Diagram

User
│
├── userId
├── fullName
├── email
├── password
├── role
└── active

```
    │
    │ One-To-One
    ▼
```

BankManager
│
├── managerId
├── contactNumber
├── active
└── bank

```
    │
    │ Many-To-One
    ▼
```

Bank
│
├── bankId
├── bankName
├── ifscCode
├── branchName
├── address
└── active

```
    │
    ├──────────────► Customer
    │
    ├──────────────► Account
    │
    └──────────────► AccountOpeningRequest
```

Customer
│
├── customerId
├── fullName
├── contactNumber
├── address
├── status
└── bank

```
    │
    │ One-To-Many
    ▼
```

Account
│
├── accountId
├── accountNumber
├── balance
├── accountType
├── accountStatus
├── openingDate
├── customer
└── bank

```
    │
    │ One-To-Many
    ▼
```

Transaction
│
├── transactionId
├── amount
├── transactionType
├── transactionTime
├── remarks
├── senderAccount
└── receiverAccount

---

# Future Enhancements

* JWT Authentication
* Role Based Authorization
* Account Statement Download (PDF)
* Customer Profile Management
* Admin Module
* Account Lock / Unlock
* Customer Activate / Deactivate
* Email Notifications
* Audit Logs
* Microservices Migration
