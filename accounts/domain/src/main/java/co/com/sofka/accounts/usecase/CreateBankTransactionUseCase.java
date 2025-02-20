package co.com.sofka.accounts.usecase;

import co.com.sofka.accounts.model.entity.Account;
import co.com.sofka.accounts.model.entity.BankTransaction;
import co.com.sofka.accounts.model.strategy.BalanceUpdateStrategyFactory;
import co.com.sofka.accounts.port.dao.AccountDao;
import co.com.sofka.accounts.port.repository.AccountRepository;
import co.com.sofka.accounts.port.repository.BankTransactionRepository;
import co.com.sofka.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateBankTransactionUseCase {
    private static final String CUENTA_NO_EXISTE = "Cuenta con numero: %s no existe";
    private final BankTransactionRepository bankTransactionRepository;
    private final AccountRepository accountRepository;
    private final AccountDao accountDao;

    public Long execute(BankTransaction bankTransaction) {
        var account = this.validateAccount(bankTransaction.getAccount());
        bankTransaction.updateAccount(account);
        var id = this.bankTransactionRepository.create(bankTransaction);
        BalanceUpdateStrategyFactory.getStrategy(bankTransaction.getTransactionType())
                .execute(account, bankTransaction.getAmount());
        this.accountRepository.save(account);
        return id;
    }

    private Account validateAccount(Account account) {
        var accountOptional = this.accountDao.findByAccountNumber(account.getAccountNumber());
        if (accountOptional.isEmpty()) {
            throw new NotFoundException(String.format(CUENTA_NO_EXISTE, account.getAccountNumber()));
        }
        return accountOptional.get();
    }
}
