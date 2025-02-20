package co.com.sofka.customers.query.handler;

import co.com.sofka.customers.model.dto.CustomerDto;
import co.com.sofka.customers.usecase.FindCustomerUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindCustomerHandler {
    private final FindCustomerUseCase findCustomerUseCase;

    public CustomerDto execute(Long id) {
        return this.findCustomerUseCase.execute(id);
    }
}
