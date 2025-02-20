package co.com.sofka.accounts.adapter.jpa;

import co.com.sofka.accounts.adapter.jpa.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {
    boolean existsByAccountNumberIgnoreCase(String accountNumber);
    Optional<AccountEntity> findByAccountNumberIgnoreCase(String accountNumber);
}
