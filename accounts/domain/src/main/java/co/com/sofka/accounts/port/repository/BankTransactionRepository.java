package co.com.sofka.accounts.port.repository;

import co.com.sofka.accounts.model.entity.BankTransaction;

public interface BankTransactionRepository {
    Long create(BankTransaction bankTransaction);
}
