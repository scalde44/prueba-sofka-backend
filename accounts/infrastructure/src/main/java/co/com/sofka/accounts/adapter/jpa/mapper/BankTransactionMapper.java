package co.com.sofka.accounts.adapter.jpa.mapper;

import co.com.sofka.accounts.adapter.jpa.model.entity.BankTransactionEntity;
import co.com.sofka.accounts.model.dto.BankTransactionDto;
import co.com.sofka.accounts.model.entity.BankTransaction;
import co.com.sofka.accounts.model.entity.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankTransactionMapper {
    private final AccountMapper accountMapper;

    public BankTransactionEntity toEntity(BankTransaction bankTransaction) {
        return new BankTransactionEntity(bankTransaction.getId(), bankTransaction.getDateTime(), bankTransaction.getTransactionType().name(),
                bankTransaction.getAmount(), bankTransaction.getBalance(), this.accountMapper.toEntity(bankTransaction.getAccount()));
    }

    public BankTransactionDto toDto(BankTransactionEntity bankTransactionEntity, String customerName) {
        return new BankTransactionDto(bankTransactionEntity.getDateTime(), customerName,
                this.accountMapper.toDomain(bankTransactionEntity.getAccount()), bankTransactionEntity.getBalance(),
                bankTransactionEntity.getAmount(), TransactionType.valueOf(bankTransactionEntity.getTransactionType()));
    }
}
