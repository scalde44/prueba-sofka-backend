package co.com.sofka.customers.adapter.dao;

import co.com.sofka.customers.adapter.jpa.CustomerJpaRepository;
import co.com.sofka.customers.adapter.jpa.mapper.CustomerMapper;
import co.com.sofka.customers.model.dto.CustomerDto;
import co.com.sofka.customers.port.dao.CustomerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerDaoAdapter implements CustomerDao {
    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> findAll() {
        return this.customerJpaRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public Optional<CustomerDto> findById(Long id) {
        return this.customerJpaRepository.findById(id)
                .map(customerMapper::toDto);
    }
}
