package co.com.sofka.accounts.command.factory;

import co.com.sofka.accounts.command.BankTransactionCommand;
import co.com.sofka.accounts.model.entity.BankTransaction;

public class BankTransactionFactory {
    public BankTransaction create(BankTransactionCommand command) {
        return new BankTransaction(command.transactionType(), command.amount(), command.accountNumber());
    }
}
