package co.com.sofka.accounts.command.handler;

import co.com.sofka.accounts.command.BankTransactionCommand;
import co.com.sofka.accounts.command.factory.BankTransactionFactory;
import co.com.sofka.accounts.usecase.CreateBankTransactionUseCase;
import co.com.sofka.application.command.CommandResponse;
import co.com.sofka.application.handler.CommandResponseHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateBankTransactionHandler implements CommandResponseHandler<BankTransactionCommand, CommandResponse<Long>> {
    private final BankTransactionFactory factory;
    private final CreateBankTransactionUseCase useCase;

    @Override
    public CommandResponse<Long> execute(BankTransactionCommand command) {
        var bankTransaction = this.factory.create(command);
        return new CommandResponse<>(this.useCase.execute(bankTransaction));
    }
}
