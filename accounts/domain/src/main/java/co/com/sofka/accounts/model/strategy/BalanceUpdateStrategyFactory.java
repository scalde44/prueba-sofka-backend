package co.com.sofka.accounts.model.strategy;

import co.com.sofka.accounts.model.entity.TransactionType;

public class BalanceUpdateStrategyFactory {
    public static BalanceUpdateStrategy getStrategy(TransactionType transactionType) {
        return switch (transactionType) {
            case DEPOSIT -> new DepositStrategy();
            case WITHDRAWAL -> new WithdrawalStrategy();
        };
    }
}
