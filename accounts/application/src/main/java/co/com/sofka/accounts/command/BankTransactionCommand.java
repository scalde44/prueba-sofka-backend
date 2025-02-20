package co.com.sofka.accounts.command;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankTransactionCommand {
    private String transactionType;
    private BigDecimal amount;
    private String accountNumber;
}
