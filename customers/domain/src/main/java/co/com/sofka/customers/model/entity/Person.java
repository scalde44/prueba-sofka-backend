package co.com.sofka.customers.model.entity;

import lombok.Getter;

import static co.com.sofka.domain.validation.ArgumentValidator.validateEnum;
import static co.com.sofka.domain.validation.ArgumentValidator.validateLessThan;
import static co.com.sofka.domain.validation.ArgumentValidator.validateRequired;

@Getter
public class Person {
    private static final int MINIMUM_AGE = 18;
    private static final String INVALID_GENDER = "The gender is incorrect";
    private static final String MINIMUM_AGE_REQUIRED = "The minimum required age is %d";

    private Long id;
    private String name;
    private Gender gender;
    private Integer age;
    private String identification;
    private String address;
    private String phoneNumber;

    public Person(Long id, String name, String gender, Integer age, String identification, String address, String phoneNumber) {
        validateRequired(name, "name");
        validateRequired(gender, "gender");
        validateRequired(age, "age");
        validateLessThan(MINIMUM_AGE, age, String.format(MINIMUM_AGE_REQUIRED, MINIMUM_AGE));
        validateRequired(identification, "identification");
        validateRequired(address, "address");
        validateRequired(phoneNumber, "phoneNumber");
        this.id = id;
        this.name = name;
        this.gender = validateEnum(gender, Gender.class, INVALID_GENDER);
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
