package co.com.sofka.accounts.model.dto;

import co.com.sofka.accounts.model.entity.Account;
import co.com.sofka.accounts.model.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BankTransactionDto(LocalDateTime date, String customer, Account account, BigDecimal initialBalance,
                                 BigDecimal amount, TransactionType transactionType) {
}
