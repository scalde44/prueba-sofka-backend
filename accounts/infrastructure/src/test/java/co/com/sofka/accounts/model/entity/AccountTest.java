package co.com.sofka.accounts.model.entity;

import co.com.sofka.accounts.testdatabuilder.AccountTestDataBuilder;
import co.com.sofka.domain.exception.InvalidValueException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private static final String INVALID_ACCOUNT_TYPE = "The account type is incorrect";
    private static final String FONDOS_INSUFICIENTES = "Fondos insuficientes";

    @Test
    void shouldCreateAccountSuccessfully() {
        var account = new AccountTestDataBuilder().build();
        assertEquals("112897523", account.getAccountNumber());
        assertEquals(AccountType.SAVINGS, account.getAccountType());
        assertEquals(new BigDecimal("1000"), account.getBalance());
        assertEquals(1L, account.getCustomerId());
    }

    @Test
    void shouldThrowExceptionWhenFundsAreInsufficient() {
        var accountBuilder = new AccountTestDataBuilder()
                .withBalance(BigDecimal.ONE.negate());

        var invalidValueException = assertThrows(InvalidValueException.class, accountBuilder::build);

        assertEquals(FONDOS_INSUFICIENTES, invalidValueException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAccountTypeIsInvalid() {
        var accountBuilder = new AccountTestDataBuilder()
                .withAccountType("CREDIT");

        var invalidValueException = assertThrows(InvalidValueException.class, accountBuilder::build);

        assertEquals(INVALID_ACCOUNT_TYPE, invalidValueException.getMessage());
    }
}
