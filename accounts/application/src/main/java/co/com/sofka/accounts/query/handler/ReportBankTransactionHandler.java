package co.com.sofka.accounts.query.handler;

import co.com.sofka.accounts.model.dto.ReportBankTransactionDto;
import co.com.sofka.accounts.model.dto.PageDto;
import co.com.sofka.accounts.usecase.CreateReportBankTransactionUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReportBankTransactionHandler {
    private final CreateReportBankTransactionUseCase createReportBankTransactionUseCase;

    public PageDto<ReportBankTransactionDto> execute(Long customerId, String startDate, String endDate, int page, int size) {
        return this.createReportBankTransactionUseCase.execute(customerId, startDate, endDate, page, size);
    }
}
