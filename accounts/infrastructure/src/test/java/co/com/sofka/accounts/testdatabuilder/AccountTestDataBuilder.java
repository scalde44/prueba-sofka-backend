package co.com.sofka.accounts.testdatabuilder;

import co.com.sofka.accounts.model.entity.Account;

import java.math.BigDecimal;

public class AccountTestDataBuilder {
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private Long customerId;

    public AccountTestDataBuilder() {
        this.accountNumber = "112897523";
        this.accountType = "SAVINGS";
        this.balance = new BigDecimal("1000");
        this.customerId = 1L;
    }

    public AccountTestDataBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountTestDataBuilder withAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountTestDataBuilder withBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public AccountTestDataBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Account build() {
        return new Account(accountNumber, accountType, balance, customerId);
    }
}
