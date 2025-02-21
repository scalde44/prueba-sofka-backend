package co.com.sofka.customers.testdatabuilder;

import co.com.sofka.customers.command.CustomerCommand;

public class CustomerCommandTestDataBuilder {
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phoneNumber;
    private String password;

    public CustomerCommandTestDataBuilder() {
        this.name = "Steven";
        this.gender = "MALE";
        this.age = 20;
        this.identification = "1005872803";
        this.address = "Calle 20";
        this.phoneNumber = "3203533423";
        this.password = "DNBifFD93";
    }

    public CustomerCommandTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerCommandTestDataBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CustomerCommandTestDataBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    public CustomerCommandTestDataBuilder withIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public CustomerCommandTestDataBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerCommandTestDataBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerCommandTestDataBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public CustomerCommand build() {
        return new CustomerCommand(name, gender, age, identification, address, phoneNumber, password);
    }
}
