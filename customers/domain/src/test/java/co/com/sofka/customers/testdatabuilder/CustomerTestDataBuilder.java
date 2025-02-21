package co.com.sofka.customers.testdatabuilder;

import co.com.sofka.customers.model.entity.Customer;

public class CustomerTestDataBuilder {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phoneNumber;
    private String password;

    public CustomerTestDataBuilder() {
        this.name = "Steven";
        this.gender = "MALE";
        this.age = 20;
        this.identification = "1005872803";
        this.address = "Calle 45";
        this.phoneNumber = "3017976885";
        this.password = "stecven23";
    }

    public CustomerTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CustomerTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerTestDataBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CustomerTestDataBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    public CustomerTestDataBuilder withIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public CustomerTestDataBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerTestDataBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerTestDataBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public Customer build() {
        return new Customer(id, name, gender, age, identification, address, phoneNumber, password);
    }
}
