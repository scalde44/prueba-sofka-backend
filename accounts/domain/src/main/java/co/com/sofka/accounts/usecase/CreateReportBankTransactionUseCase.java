package co.com.sofka.accounts.usecase;

import co.com.sofka.accounts.model.dto.BankTransactionDto;
import co.com.sofka.accounts.model.dto.PageDto;
import co.com.sofka.accounts.model.dto.ReportBankTransactionDto;
import co.com.sofka.accounts.model.entity.TransactionType;
import co.com.sofka.accounts.port.dao.BankTransactionDao;
import co.com.sofka.accounts.port.dao.CustomerDao;
import co.com.sofka.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;

import static co.com.sofka.domain.validation.ArgumentValidator.validateDate;
import static co.com.sofka.domain.validation.ArgumentValidator.validateRequired;

@RequiredArgsConstructor
public class CreateReportBankTransactionUseCase {
    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static final String FECHA_INVALIDA = "%s no cumple con el formato de fecha %s";
    private static final String CLIENTE_NO_EXISTE = "Cliente con id %d no existe";
    private static final String PAGINA_INVALIDA = "La pagina no debe ser menor a 0";
    private static final String CANTIDAD_INVALIDA = "La cantidad no debe ser menor a 0";
    private final BankTransactionDao bankTransactionDao;
    private final CustomerDao customerDao;

    public PageDto<ReportBankTransactionDto> execute(Long customerId, String startDate, String endDate, int page, int size) {
        validateRequired(customerId, "customerId");
        validateRequired(startDate, "startDate");
        var startLocalDate = validateDate(startDate, DATE_PATTERN, String.format(FECHA_INVALIDA, "startDate", DATE_PATTERN));
        validateRequired(endDate, "endDate");
        var endLocalDate = validateDate(endDate, DATE_PATTERN, String.format(FECHA_INVALIDA, "endDate", DATE_PATTERN));
        this.validatePageable(page, size);
        var customerOptional = this.customerDao.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new NotFoundException(String.format(CLIENTE_NO_EXISTE, customerId));
        }
        var customer = customerOptional.get();
        PageDto<BankTransactionDto> transactionsPage = this.bankTransactionDao.findByDateRange(customer.id(), customer.name(),
                startLocalDate.atStartOfDay(), endLocalDate.atTime(LocalTime.MAX), page, size);
        var transactions = transactionsPage.content().stream()
                .map(bankT -> {
                    var account = bankT.account();
                    var amount = this.parseAmount(bankT.amount(), bankT.transactionType());
                    return new ReportBankTransactionDto(
                            bankT.date(),
                            bankT.customer(),
                            account.getAccountNumber(),
                            account.getAccountType(),
                            bankT.initialBalance(),
                            account.getStatus(),
                            amount,
                            this.balance(amount, bankT.initialBalance())
                    );
                })
                .toList();
        return new PageDto<>(transactions, transactionsPage.pageNumber(), transactionsPage.pageSize(),
                transactionsPage.totalElements(), transactionsPage.totalPages());
    }

    private void validatePageable(int page, int size) {
        if (page < 0) {
            throw new IllegalArgumentException(PAGINA_INVALIDA);
        }
        if (size < 0) {
            throw new IllegalArgumentException(CANTIDAD_INVALIDA);
        }
    }

    private BigDecimal balance(BigDecimal amount, BigDecimal initialBalance) {
        return initialBalance.add(amount);
    }

    private BigDecimal parseAmount(BigDecimal amount, TransactionType transactionType) {
        return (transactionType.equals(TransactionType.WITHDRAWAL)) ? amount.negate() : amount;
    }
}
