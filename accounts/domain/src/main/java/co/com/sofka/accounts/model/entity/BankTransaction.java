package co.com.sofka.accounts.model.entity;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static co.com.sofka.domain.validation.ArgumentValidator.validateEnum;
import static co.com.sofka.domain.validation.ArgumentValidator.validateMinValue;
import static co.com.sofka.domain.validation.ArgumentValidator.validateRequired;

@Getter
public class BankTransaction {
    private static final String INVALID_TRANSACTION_TYPE = "The transaction type is incorrect";
    private static final BigDecimal MIN_BALANCE = BigDecimal.ZERO;
    private static final String FONDOS_INSUFICIENTES = "Fondos insuficientes";
    private static final String MONTO_DEBE_SER_MAYOR = "El monto de la transaccion debe ser mayor a %d";
    private Long id;
    private LocalDateTime dateTime;
    private TransactionType transactionType;
    private BigDecimal amount;
    private BigDecimal balance;
    private Account account;

    public BankTransaction(String transactionType, BigDecimal amount, String accountNumber) {
        validateRequired(transactionType, "transactionType");
        validateRequired(amount, "amount");
        validateMinValue(amount, MIN_BALANCE, String.format(MONTO_DEBE_SER_MAYOR, MIN_BALANCE.intValue()));
        this.dateTime = LocalDateTime.now();
        this.transactionType = validateEnum(transactionType, TransactionType.class, INVALID_TRANSACTION_TYPE);
        this.amount = amount;
        this.account = new Account(accountNumber);
    }

    public void updateAccount(Account account) {
        this.account = account;
        this.updateBalance(account.getBalance());
    }

    private void updateBalance(BigDecimal balance) {
        validateRequired(balance, "balance");
        if (this.transactionType.equals(TransactionType.WITHDRAWAL) && this.amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException(FONDOS_INSUFICIENTES);
        }
        this.balance = balance;
    }
}
