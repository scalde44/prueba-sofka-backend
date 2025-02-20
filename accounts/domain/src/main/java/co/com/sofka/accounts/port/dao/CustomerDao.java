package co.com.sofka.accounts.port.dao;

import co.com.sofka.accounts.model.dto.CustomerDto;

import java.util.Optional;

public interface CustomerDao {
    Optional<CustomerDto> findById(Long id);
}
