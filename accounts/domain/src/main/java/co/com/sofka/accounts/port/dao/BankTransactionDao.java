package co.com.sofka.accounts.port.dao;

import co.com.sofka.accounts.model.dto.BankTransactionDto;
import co.com.sofka.accounts.model.dto.PageDto;

import java.time.LocalDateTime;

public interface BankTransactionDao {
    PageDto<BankTransactionDto> findByDateRange(Long customerId, String customerName, LocalDateTime startDate,
                                                LocalDateTime endDate, int page, int size);
}
