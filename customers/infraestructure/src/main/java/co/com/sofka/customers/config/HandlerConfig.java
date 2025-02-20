package co.com.sofka.customers.config;

import co.com.sofka.customers.command.factory.CustomerFactory;
import co.com.sofka.customers.command.handler.CreateCustomerHandler;
import co.com.sofka.customers.query.handler.FindCustomerHandler;
import co.com.sofka.customers.usecase.CreateCustomerUseCase;
import co.com.sofka.customers.usecase.FindCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfig {
    @Bean
    public CustomerFactory customerFactory() {
        return new CustomerFactory();
    }

    @Bean
    public CreateCustomerHandler createCustomerHandler(CustomerFactory factory, CreateCustomerUseCase useCase) {
        return new CreateCustomerHandler(factory, useCase);
    }

    @Bean
    public FindCustomerHandler findCustomerHandler(FindCustomerUseCase useCase) {
        return new FindCustomerHandler(useCase);
    }
}
