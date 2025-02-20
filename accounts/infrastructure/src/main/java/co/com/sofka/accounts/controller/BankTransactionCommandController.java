package co.com.sofka.accounts.controller;

import co.com.sofka.accounts.command.BankTransactionCommand;
import co.com.sofka.accounts.command.handler.CreateBankTransactionHandler;
import co.com.sofka.application.command.CommandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movimientos")
@RequiredArgsConstructor
public class BankTransactionCommandController {
    private final CreateBankTransactionHandler createBankTransactionHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommandResponse<Long> create(@RequestBody BankTransactionCommand command) {
        return this.createBankTransactionHandler.execute(command);
    }
}
