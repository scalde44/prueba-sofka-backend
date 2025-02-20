package co.com.sofka.accounts.adapter.dao;

import co.com.sofka.accounts.adapter.client.CustomerClient;
import co.com.sofka.accounts.model.dto.CustomerDto;
import co.com.sofka.accounts.port.dao.CustomerDao;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerDaoAdapter implements CustomerDao {
    private final CustomerClient customerClient;

    @Override
    public Optional<CustomerDto> findById(Long id) {
        try {
            return Optional.ofNullable(this.customerClient.findCustomer(id));
        } catch (FeignException.NotFound e) {
            return Optional.empty();
        }
    }
}
