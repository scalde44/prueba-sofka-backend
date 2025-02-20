package co.com.sofka.customers.model.dto;

import co.com.sofka.customers.model.entity.Gender;

public record CustomerDto(Long id,
                          String name,
                          Gender gender,
                          Integer age,
                          String identification,
                          String address,
                          String phoneNumber,
                          String password,
                          Boolean status) {
}
