package co.com.sofka.accounts.adapter.dao;

import co.com.sofka.accounts.adapter.jpa.BankTransactionJpaRepository;
import co.com.sofka.accounts.adapter.jpa.mapper.BankTransactionMapper;
import co.com.sofka.accounts.adapter.jpa.mapper.PageMapper;
import co.com.sofka.accounts.model.dto.BankTransactionDto;
import co.com.sofka.accounts.model.dto.PageDto;
import co.com.sofka.accounts.port.dao.BankTransactionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Repository
public class BankTransactionDaoAdapter implements BankTransactionDao {
    private final BankTransactionJpaRepository bankTransactionJpaRepository;
    private final BankTransactionMapper bankTransactionMapper;
    private final PageMapper pageMapper;

    @Override
    public PageDto<BankTransactionDto> findByDateRange(Long customerId, String customerName, LocalDateTime startDate,
                                                       LocalDateTime endDate, int page, int size) {
        var bankPage = this.bankTransactionJpaRepository.findByAccount_CustomerIdAndDateTimeBetweenOrderByDateTimeAsc(customerId, startDate, endDate, PageRequest.of(page, size))
                .map(bankTransactionEntity -> this.bankTransactionMapper.toDto(bankTransactionEntity, customerName));
        return this.pageMapper.toDto(bankPage);
    }
}
