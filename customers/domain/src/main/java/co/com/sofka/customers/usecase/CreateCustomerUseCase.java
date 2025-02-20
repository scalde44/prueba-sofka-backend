package co.com.sofka.customers.usecase;

import co.com.sofka.customers.model.entity.Customer;
import co.com.sofka.customers.port.repository.CustomerRepository;
import co.com.sofka.domain.exception.DuplicateException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCustomerUseCase {
    private static final String CUSTOMER_ALREADY_EXISTS = "Customer with identification: %s already exists";
    private final CustomerRepository customerRepository;

    public Long execute(Customer customer) {
        this.validateExist(customer.getIdentification());
        return this.customerRepository.create(customer);
    }

    private void validateExist(String identification) {
        if (this.customerRepository.exists(identification)) {
            throw new DuplicateException(String.format(CUSTOMER_ALREADY_EXISTS, identification));
        }
    }
}
