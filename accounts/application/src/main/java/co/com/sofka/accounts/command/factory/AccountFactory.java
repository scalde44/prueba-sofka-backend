package co.com.sofka.accounts.command.factory;

import co.com.sofka.accounts.command.AccountCommand;
import co.com.sofka.accounts.model.entity.Account;

public class AccountFactory {
    public Account create(AccountCommand command) {
        return new Account(command.getAccountNumber(), command.getAccountType(), command.getBalance(), command.getCustomerId());
    }
}
