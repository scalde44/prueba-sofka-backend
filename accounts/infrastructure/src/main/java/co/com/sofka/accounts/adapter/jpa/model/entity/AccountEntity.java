package co.com.sofka.accounts.adapter.jpa.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;
    @Column(name = "account_type", nullable = false)
    private String accountType;
    private BigDecimal balance;
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    private Boolean status;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BankTransactionEntity> transactions;

    public AccountEntity(Long id, String accountNumber, String accountType, BigDecimal balance, Long customerId, Boolean status) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;
        this.status = status;
    }
}
