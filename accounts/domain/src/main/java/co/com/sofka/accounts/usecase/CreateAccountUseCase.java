package co.com.sofka.accounts.usecase;

import co.com.sofka.accounts.model.entity.Account;
import co.com.sofka.accounts.port.dao.CustomerDao;
import co.com.sofka.accounts.port.repository.AccountRepository;
import co.com.sofka.domain.exception.DuplicateException;
import co.com.sofka.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccountUseCase {
    private static final String ACCOUNT_ALREADY_EXISTS = "Account with number: %s already exists";
    private static final String CLIENTE_NO_EXISTE = "Cliente con id %d no existe";
    private final AccountRepository accountRepository;
    private final CustomerDao customerDao;

    public String execute(Account account) {
        this.validateExist(account.getAccountNumber());
        this.validateCustomer(account.getCustomerId());
        return this.accountRepository.save(account);
    }

    private void validateExist(String accountNumber) {
        if (this.accountRepository.exists(accountNumber)) {
            throw new DuplicateException(String.format(ACCOUNT_ALREADY_EXISTS, accountNumber));
        }
    }

    private void validateCustomer(Long id) {
        var customerOptional = this.customerDao.findById(id);
        if (customerOptional.isEmpty()) {
            throw new NotFoundException(String.format(CLIENTE_NO_EXISTE, id));
        }
    }
}
