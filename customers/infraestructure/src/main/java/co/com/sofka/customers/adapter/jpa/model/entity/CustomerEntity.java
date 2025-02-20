package co.com.sofka.customers.adapter.jpa.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "person_id")
public class CustomerEntity extends PersonEntity {
    private String password;
    private Boolean status;

    public CustomerEntity(Long personId, String name, String gender, Integer age, String identification, String address,
                          String phone, String password, Boolean status) {
        super(personId, name, gender, age, identification, address, phone);
        this.password = password;
        this.status = status;
    }
}
