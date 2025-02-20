package co.com.sofka.accounts.adapter.jpa.mapper;

import co.com.sofka.accounts.adapter.jpa.model.entity.AccountEntity;
import co.com.sofka.accounts.model.dto.AccountDto;
import co.com.sofka.accounts.model.entity.Account;
import co.com.sofka.accounts.model.entity.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountEntity toEntity(Account account) {
        return new AccountEntity(account.getId(), account.getAccountNumber(), account.getAccountType().name(),
                account.getBalance(), account.getCustomerId(), account.getStatus());
    }

    public AccountDto toDto(AccountEntity account) {
        return new AccountDto(account.getId(), account.getAccountNumber(), AccountType.valueOf(account.getAccountType()),
                account.getBalance(), account.getCustomerId(), account.getStatus());
    }

    public Account toDomain(AccountEntity account) {
        return new Account(account.getId(), account.getAccountNumber(), AccountType.valueOf(account.getAccountType()),
                account.getBalance(), account.getCustomerId(), account.getStatus());
    }
}
