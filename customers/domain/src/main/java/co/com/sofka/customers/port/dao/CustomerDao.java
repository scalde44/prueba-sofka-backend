package co.com.sofka.customers.port.dao;

import co.com.sofka.customers.model.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<CustomerDto> findAll();

    Optional<CustomerDto> findById(Long id);
}
