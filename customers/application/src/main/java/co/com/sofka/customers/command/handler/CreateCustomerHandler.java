package co.com.sofka.customers.command.handler;

import co.com.sofka.application.command.CommandResponse;
import co.com.sofka.customers.command.CustomerCommand;
import co.com.sofka.customers.command.factory.CustomerFactory;
import co.com.sofka.application.handler.CommandResponseHandler;
import co.com.sofka.customers.usecase.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCustomerHandler implements CommandResponseHandler<CustomerCommand, CommandResponse<Long>> {
    private final CustomerFactory customerFactory;
    private final CreateCustomerUseCase createCustomerUseCase;

    @Override
    public CommandResponse<Long> execute(CustomerCommand command) {
        var customer = this.customerFactory.create(command);
        return new CommandResponse<>(this.createCustomerUseCase.execute(customer));
    }
}
