package co.com.sofka.customers.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCommand {
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phoneNumber;
    private String password;
}
