package co.com.sofka.customers.model.entity;

import co.com.sofka.customers.testdatabuilder.CustomerTestDataBuilder;
import co.com.sofka.domain.exception.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {
    private static final int MINIMUM_AGE = 18;
    private static final String INVALID_GENDER = "The gender is incorrect";
    private static final String MINIMUM_AGE_REQUIRED = "The minimum required age is %d";

    @Test
    void shouldCreatePersonSuccessfully() {
        var customer = new CustomerTestDataBuilder().build();
        assertEquals("Steven", customer.getName());
        assertEquals(Gender.MALE, customer.getGender());
        assertEquals(20, customer.getAge());
        assertEquals("1005872803", customer.getIdentification());
        assertEquals("Calle 45", customer.getAddress());
        assertEquals("3017976885", customer.getPhoneNumber());
        assertEquals("stecven23", customer.getPassword());
    }

    @Test
    void shouldThrowExceptionWhenAgeIsLessThanMinimum() {
        var customerBuilder = new CustomerTestDataBuilder()
                .withAge(17);

        var invalidValueException = assertThrows(InvalidValueException.class, customerBuilder::build);

        assertEquals(String.format(MINIMUM_AGE_REQUIRED, MINIMUM_AGE), invalidValueException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenGenderIsInvalid() {
        var customerBuilder = new CustomerTestDataBuilder()
                .withGender("NO");

        var invalidValueException = assertThrows(InvalidValueException.class, customerBuilder::build);

        assertEquals(INVALID_GENDER, invalidValueException.getMessage());
    }

}
