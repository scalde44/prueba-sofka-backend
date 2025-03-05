package co.com.sofka.accounts.model.strategy;

import co.com.sofka.accounts.model.entity.Account;

import java.math.BigDecimal;

public final class WithdrawalStrategy implements BalanceUpdateStrategy {

    @Override
    public void execute(Account account, BigDecimal amount) {
        account.withdrawal(amount);
    }
}
