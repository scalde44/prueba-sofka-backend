package co.com.sofka.customers.adapter.jpa.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", updatable = false)
    private Long personId;
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
}
