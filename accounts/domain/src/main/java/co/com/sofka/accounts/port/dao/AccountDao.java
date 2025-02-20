package co.com.sofka.accounts.port.dao;

import co.com.sofka.accounts.model.entity.Account;

import java.util.Optional;

public interface AccountDao {
    Optional<Account> findByAccountNumber(String accountNumber);
}
