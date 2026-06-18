# banking-application
Banking application using 
-Backend-SpringBoot
-FrontEnd-ReactJs
-DataBase-MySQL

-CRUD operations
-Exception Handling
-File Uploading and Deleting
-Spring Security

#Complete Project Architecture
┌─────────────────────────────┐
│          ADMIN              │
└─────────────┬───────────────┘
              │
              ▼
      Create Banks
              │
              ▼
     Create Bank Managers
              │
              ▼
┌─────────────────────────────┐
│       BANK MANAGER          │
└─────────────┬───────────────┘
              │
              ├──────────────► Create Customer
              │
              ├──────────────► Approve Customer
              │
              ├──────────────► Deactivate Customer
              │
              ├──────────────► Create Account
              │
              ├──────────────► Lock Account
              │
              ├──────────────► Unlock Account
              │
              ├──────────────► Deposit Money
              │
              └──────────────► Withdraw Money
                              
                              ▼
┌─────────────────────────────┐
│         CUSTOMER            │
└─────────────┬───────────────┘
              │
              ├──────────────► Self Register
              │
              ├──────────────► Login
              │
              ├──────────────► View Accounts
              │
              ├──────────────► Check Balance
              │
              ├──────────────► Transfer Money
              │
              ├──────────────► View Transactions
              │
              ├──────────────► View Statement
              │
              └──────────────► Download Statement


#Database Flow

USER
│
├── ADMIN
├── BANK_MANAGER
└── CUSTOMER

BANK
│
├── BANK_MANAGER
├── CUSTOMER
└── ACCOUNT

ACCOUNT
│
└── TRANSACTION


#Entity Relationship Diagram

User
│
├── userId
├── fullName
├── email
├── password
├── role
└── active

        │
        │ One-To-One
        ▼

Customer
│
├── customerId
├── contactNumber
├── address
├── status
└── bank

        │
        │ One-To-Many
        ▼

Account
│
├── accountId
├── accountNumber
├── balance
├── accountType
├── accountStatus
└── openingDate

        │
        │ One-To-Many
        ▼

Transaction

