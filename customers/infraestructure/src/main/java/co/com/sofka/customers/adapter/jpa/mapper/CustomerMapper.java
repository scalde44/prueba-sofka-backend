package co.com.sofka.customers.adapter.jpa.mapper;

import co.com.sofka.customers.adapter.jpa.model.entity.CustomerEntity;
import co.com.sofka.customers.model.dto.CustomerDto;
import co.com.sofka.customers.model.entity.Customer;
import co.com.sofka.customers.model.entity.Gender;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerEntity toEntity(Customer customer) {
        return new CustomerEntity(
                customer.getId(), customer.getName(), customer.getGender().name(), customer.getAge(), customer.getIdentification(),
                customer.getAddress(), customer.getPhoneNumber(), customer.getPassword(), customer.getStatus()
        );
    }

    public CustomerDto toDto(CustomerEntity customer) {
        return new CustomerDto(customer.getPersonId(), customer.getName(), Gender.valueOf(customer.getGender()),
                customer.getAge(), customer.getIdentification(), customer.getAddress(), customer.getPhone(),
                customer.getPassword(), customer.getStatus());
    }
}
