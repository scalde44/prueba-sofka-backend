package co.com.sofka.customers.port.repository;

import co.com.sofka.customers.model.entity.Customer;

public interface CustomerRepository {
    Long create(Customer customer);

    boolean exists(String identification);
}
