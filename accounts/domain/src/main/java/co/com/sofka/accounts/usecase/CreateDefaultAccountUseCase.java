package co.com.sofka.accounts.usecase;

import co.com.sofka.accounts.model.entity.Account;
import co.com.sofka.accounts.model.entity.AccountType;
import co.com.sofka.accounts.port.dao.CustomerDao;
import co.com.sofka.accounts.port.repository.AccountRepository;
import co.com.sofka.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Random;

@RequiredArgsConstructor
public class CreateDefaultAccountUseCase {
    private static final String CLIENTE_NO_EXISTE = "Cliente con id %d no existe";
    private final AccountRepository accountRepository;
    private final CustomerDao customerDao;

    public void execute(Long customerId) {
        this.validateCustomer(customerId);
        var account = new Account(this.generateAccountNumber(), AccountType.SAVINGS.name(), BigDecimal.ZERO, customerId);
        this.accountRepository.save(account);
    }

    private void validateCustomer(Long id) {
        var customerOptional = this.customerDao.findById(id);
        if (customerOptional.isEmpty()) {
            throw new NotFoundException(String.format(CLIENTE_NO_EXISTE, id));
        }
    }

    private String generateAccountNumber() {
        Random random = new Random();
        int number = random.nextInt(1_000_000_000);
        return String.valueOf(number);
    }
}
