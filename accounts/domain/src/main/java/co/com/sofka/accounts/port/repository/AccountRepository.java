package co.com.sofka.accounts.port.repository;

import co.com.sofka.accounts.model.entity.Account;

public interface AccountRepository {
    String save(Account account);

    boolean exists(String accountNumber);
}
