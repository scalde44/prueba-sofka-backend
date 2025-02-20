package co.com.sofka.accounts.adapter.repository;

import co.com.sofka.accounts.adapter.jpa.AccountJpaRepository;
import co.com.sofka.accounts.adapter.jpa.mapper.AccountMapper;
import co.com.sofka.accounts.model.entity.Account;
import co.com.sofka.accounts.port.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {
    private final AccountJpaRepository accountJpaRepository;
    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public String save(Account account) {
        var accountEntity = this.accountMapper.toEntity(account);
        var accountSave = this.accountJpaRepository.save(accountEntity);
        return accountSave.getAccountNumber();
    }

    @Override
    public boolean exists(String accountNumber) {
        return this.accountJpaRepository.existsByAccountNumberIgnoreCase(accountNumber);
    }
}
