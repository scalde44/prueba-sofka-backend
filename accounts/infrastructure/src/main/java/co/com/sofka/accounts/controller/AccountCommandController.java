package co.com.sofka.accounts.controller;

import co.com.sofka.accounts.command.AccountCommand;
import co.com.sofka.accounts.command.handler.CreateAccountHandler;
import co.com.sofka.application.command.CommandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cuentas")
@RequiredArgsConstructor
public class AccountCommandController {
    private final CreateAccountHandler createAccountHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommandResponse<String> create(@RequestBody AccountCommand command) {
        return this.createAccountHandler.execute(command);
    }
}
