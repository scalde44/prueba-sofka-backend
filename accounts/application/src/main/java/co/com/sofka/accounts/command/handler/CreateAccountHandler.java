package co.com.sofka.accounts.command.handler;

import co.com.sofka.accounts.command.AccountCommand;
import co.com.sofka.accounts.command.factory.AccountFactory;
import co.com.sofka.accounts.usecase.CreateAccountUseCase;
import co.com.sofka.application.command.CommandResponse;
import co.com.sofka.application.handler.CommandResponseHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccountHandler implements CommandResponseHandler<AccountCommand, CommandResponse<String>> {
    private final AccountFactory accountFactory;
    private final CreateAccountUseCase createAccountUseCase;

    @Override
    public CommandResponse<String> execute(AccountCommand command) {
        var account = this.accountFactory.create(command);
        return new CommandResponse<>(this.createAccountUseCase.execute(account));
    }
}
