package co.com.sofka.customers.usecase;

import co.com.sofka.customers.model.dto.CustomerDto;
import co.com.sofka.customers.port.dao.CustomerDao;
import co.com.sofka.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindCustomerUseCase {
    private static final String CLIENTE_NO_ENCONTRADO = "Cliente con id: %d no existe";
    private final CustomerDao customerDao;

    public CustomerDto execute(Long id) {
        var customer = this.customerDao.findById(id);
        if (customer.isEmpty()) {
            throw new NotFoundException(String.format(CLIENTE_NO_ENCONTRADO, id));
        }
        return customer.get();
    }
}
