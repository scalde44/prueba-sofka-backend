package co.com.sofka.accounts.model.dto;

import co.com.sofka.accounts.model.entity.AccountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReportBankTransactionDto(LocalDateTime date, String customer, String accountNumber,
                                       AccountType accountType, BigDecimal initialBalance, Boolean status,
                                       BigDecimal amount, BigDecimal availableBalance) {
}
