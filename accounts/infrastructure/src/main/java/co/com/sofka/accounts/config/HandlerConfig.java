package co.com.sofka.accounts.config;

import co.com.sofka.accounts.command.factory.AccountFactory;
import co.com.sofka.accounts.command.factory.BankTransactionFactory;
import co.com.sofka.accounts.command.handler.CreateAccountHandler;
import co.com.sofka.accounts.command.handler.CreateBankTransactionHandler;
import co.com.sofka.accounts.query.handler.ReportBankTransactionHandler;
import co.com.sofka.accounts.usecase.CreateAccountUseCase;
import co.com.sofka.accounts.usecase.CreateBankTransactionUseCase;
import co.com.sofka.accounts.usecase.CreateReportBankTransactionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfig {
    @Bean
    public AccountFactory accountFactory() {
        return new AccountFactory();
    }

    @Bean
    public BankTransactionFactory bankTransactionFactory() {
        return new BankTransactionFactory();
    }

    @Bean
    public CreateAccountHandler createAccountHandler(AccountFactory factory, CreateAccountUseCase useCase) {
        return new CreateAccountHandler(factory, useCase);
    }

    @Bean
    public CreateBankTransactionHandler createBankTransactionHandler(BankTransactionFactory factory, CreateBankTransactionUseCase useCase) {
        return new CreateBankTransactionHandler(factory, useCase);
    }

    @Bean
    public ReportBankTransactionHandler reportBankTransactionHandler(CreateReportBankTransactionUseCase useCase) {
        return new ReportBankTransactionHandler(useCase);
    }
}
