package co.com.sofka.accounts.command;

import java.math.BigDecimal;

public record BankTransactionCommand(String transactionType, BigDecimal amount, String accountNumber) {
}
