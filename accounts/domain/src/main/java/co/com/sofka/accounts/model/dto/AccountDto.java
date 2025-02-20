package co.com.sofka.accounts.model.dto;

import co.com.sofka.accounts.model.entity.AccountType;

import java.math.BigDecimal;

public record AccountDto(Long id,
                         String accountNumber,
                         AccountType accountType,
                         BigDecimal balance,
                         Long customerId,
                         Boolean status) {
}
