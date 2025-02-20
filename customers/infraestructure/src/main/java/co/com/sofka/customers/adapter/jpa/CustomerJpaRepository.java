package co.com.sofka.customers.adapter.jpa;

import co.com.sofka.customers.adapter.jpa.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
    boolean existsByIdentificationIgnoreCase(String identification);
}
