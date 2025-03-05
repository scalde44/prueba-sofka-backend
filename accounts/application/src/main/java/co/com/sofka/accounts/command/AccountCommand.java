package co.com.sofka.accounts.command;


import java.math.BigDecimal;

public record AccountCommand(String accountNumber, String accountType, BigDecimal balance, Long customerId) {
}
