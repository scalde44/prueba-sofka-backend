package co.com.sofka.customers.controller;

import co.com.sofka.customers.model.dto.CustomerDto;
import co.com.sofka.customers.query.handler.FindCustomerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class CustomerQueryController {
    private final FindCustomerHandler findCustomerHandler;

    @GetMapping("/{id}")
    public CustomerDto findCustomer(@PathVariable Long id) {
        return this.findCustomerHandler.execute(id);
    }
}
