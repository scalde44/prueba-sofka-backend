package co.com.sofka.accounts.adapter.jpa;

import co.com.sofka.accounts.adapter.jpa.model.entity.BankTransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface BankTransactionJpaRepository extends JpaRepository<BankTransactionEntity, Long> {
    Page<BankTransactionEntity> findByAccount_CustomerIdAndDateTimeBetweenOrderByDateTimeAsc(Long customerId, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd, Pageable pageable);

}
