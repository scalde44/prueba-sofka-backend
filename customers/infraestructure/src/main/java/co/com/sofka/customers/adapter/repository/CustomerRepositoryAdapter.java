package co.com.sofka.customers.adapter.repository;

import co.com.sofka.customers.adapter.jpa.CustomerJpaRepository;
import co.com.sofka.customers.adapter.jpa.mapper.CustomerMapper;
import co.com.sofka.customers.model.entity.Customer;
import co.com.sofka.customers.port.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {
    private final CustomerJpaRepository repository;
    private final CustomerMapper mapper;

    @Override
    @Transactional
    public Long create(Customer customer) {
        var customerEntity = this.mapper.toEntity(customer);
        var customerSave = this.repository.save(customerEntity);
        return customerSave.getPersonId();
    }

    @Override
    public boolean exists(String identification) {
        return this.repository.existsByIdentificationIgnoreCase(identification);
    }
}
