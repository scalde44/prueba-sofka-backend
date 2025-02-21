package co.com.sofka.customers.model.entity;

import lombok.Getter;

import static co.com.sofka.domain.validation.ArgumentValidator.validateRequired;

@Getter
public class Customer extends Person {
    private String password;
    private Boolean status;

    public Customer(Long id, String name, String gender, Integer age, String identification, String address, String phoneNumber,
                    String password) {
        super(id, name, gender, age, identification, address, phoneNumber);
        validateRequired(password, "password");
        this.password = password;
        this.status = true;
    }
}
