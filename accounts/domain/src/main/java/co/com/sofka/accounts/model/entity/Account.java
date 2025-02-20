package co.com.sofka.accounts.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

import static co.com.sofka.domain.validation.ArgumentValidator.validateEnum;
import static co.com.sofka.domain.validation.ArgumentValidator.validateMinValue;
import static co.com.sofka.domain.validation.ArgumentValidator.validateRequired;

@Getter
@AllArgsConstructor
public class Account {
    private static final String INVALID_ACCOUNT_TYPE = "The account type is incorrect";
    private static final BigDecimal MIN_BALANCE = BigDecimal.ZERO;
    private static final String FONDOS_INSUFICIENTES = "Fondos insuficientes";
    private Long id;
    private String accountNumber;
    private AccountType accountType;
    private BigDecimal balance;
    private Long customerId;
    private Boolean status;

    public Account(String accountNumber, String accountType, BigDecimal balance, Long customerId) {
        validateRequired(accountNumber, "accountNumber");
        validateRequired(accountType, "accountType");
        validateRequired(balance, "balance");
        validateMinValue(balance, MIN_BALANCE, FONDOS_INSUFICIENTES);
        validateRequired(customerId, "customerId");
        this.accountNumber = accountNumber;
        this.accountType = validateEnum(accountType, AccountType.class, INVALID_ACCOUNT_TYPE);
        this.balance = balance;
        this.customerId = customerId;
        this.status = true;
    }

    public Account(String accountNumber) {
        validateRequired(accountNumber, "accountNumber");
        this.accountNumber = accountNumber;
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdrawal(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException(FONDOS_INSUFICIENTES);
        }
        this.balance = this.balance.subtract(amount);
    }
}
