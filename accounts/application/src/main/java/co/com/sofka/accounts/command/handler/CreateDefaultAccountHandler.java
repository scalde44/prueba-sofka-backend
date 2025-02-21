package co.com.sofka.accounts.command.handler;

import co.com.sofka.accounts.command.CustomerCommand;
import co.com.sofka.accounts.usecase.CreateDefaultAccountUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateDefaultAccountHandler {
    private final CreateDefaultAccountUseCase createDefaultAccountUseCase;

    public void execute(CustomerCommand command) {
        this.createDefaultAccountUseCase.execute(command.customerId());
    }
}
