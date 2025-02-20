package co.com.sofka.accounts.adapter.dao;

import co.com.sofka.accounts.adapter.jpa.AccountJpaRepository;
import co.com.sofka.accounts.adapter.jpa.mapper.AccountMapper;
import co.com.sofka.accounts.model.entity.Account;
import co.com.sofka.accounts.port.dao.AccountDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AccountDaoAdapter implements AccountDao {
    private final AccountMapper accountMapper;
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return this.accountJpaRepository.findByAccountNumberIgnoreCase(accountNumber)
                .map(accountMapper::toDomain);
    }
}
