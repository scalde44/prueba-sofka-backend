package co.com.sofka.accounts.model.strategy;

import co.com.sofka.accounts.model.entity.Account;

import java.math.BigDecimal;

public sealed interface BalanceUpdateStrategy permits DepositStrategy, WithdrawalStrategy {
    void execute(Account account, BigDecimal amount);
}
