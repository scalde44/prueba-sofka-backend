package co.com.sofka.accounts.command;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountCommand {
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private Long customerId;
}
