package co.com.sofka.accounts.adapter.repository;

import co.com.sofka.accounts.adapter.jpa.BankTransactionJpaRepository;
import co.com.sofka.accounts.adapter.jpa.mapper.BankTransactionMapper;
import co.com.sofka.accounts.model.entity.BankTransaction;
import co.com.sofka.accounts.port.repository.BankTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BankTransactionRepositoryAdapter implements BankTransactionRepository {
    private final BankTransactionJpaRepository bankTransactionJpaRepository;
    private final BankTransactionMapper bankTransactionMapper;

    @Override
    public Long create(BankTransaction bankTransaction) {
        var bankTransactionEntity = this.bankTransactionMapper.toEntity(bankTransaction);
        var bankTransactionSave = this.bankTransactionJpaRepository.save(bankTransactionEntity);
        return bankTransactionSave.getId();
    }
}
