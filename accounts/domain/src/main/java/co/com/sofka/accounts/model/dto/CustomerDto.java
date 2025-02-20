package co.com.sofka.accounts.model.dto;

public record CustomerDto(Long id,
                          String name,
                          Integer age,
                          String identification,
                          String address,
                          String phoneNumber,
                          String password,
                          Boolean status) {
}
