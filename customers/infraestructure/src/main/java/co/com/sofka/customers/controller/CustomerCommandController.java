package co.com.sofka.customers.controller;

import co.com.sofka.application.command.CommandResponse;
import co.com.sofka.customers.command.CustomerCommand;
import co.com.sofka.customers.command.handler.CreateCustomerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class CustomerCommandController {
    private final CreateCustomerHandler createCustomerHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommandResponse<Long> create(@RequestBody CustomerCommand customerCommand) {
        return this.createCustomerHandler.execute(customerCommand);
    }
}
