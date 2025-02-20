package co.com.sofka.customers.command.factory;

import co.com.sofka.customers.command.CustomerCommand;
import co.com.sofka.customers.model.entity.Customer;

public class CustomerFactory {
    public Customer create(CustomerCommand command) {
        return new Customer(command.getName(), command.getGender(), command.getAge(),
                command.getIdentification(), command.getAddress(), command.getPhoneNumber(),
                command.getPassword());
    }
}
