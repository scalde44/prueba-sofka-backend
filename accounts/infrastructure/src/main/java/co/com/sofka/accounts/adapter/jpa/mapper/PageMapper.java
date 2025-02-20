package co.com.sofka.accounts.adapter.jpa.mapper;

import co.com.sofka.accounts.model.dto.BankTransactionDto;
import co.com.sofka.accounts.model.dto.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {
    public PageDto<BankTransactionDto> toDto(Page<BankTransactionDto> page) {
        return new PageDto<>(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages());
    }
}
