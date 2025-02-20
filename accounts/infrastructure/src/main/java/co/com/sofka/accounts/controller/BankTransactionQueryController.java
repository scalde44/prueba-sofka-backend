package co.com.sofka.accounts.controller;

import co.com.sofka.accounts.model.dto.ReportBankTransactionDto;
import co.com.sofka.accounts.model.dto.PageDto;
import co.com.sofka.accounts.query.handler.ReportBankTransactionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movimientos")
@RequiredArgsConstructor
public class BankTransactionQueryController {
    private final ReportBankTransactionHandler reportBankTransactionHandler;

    @GetMapping("/reportes")
    public PageDto<ReportBankTransactionDto> report(
            @RequestParam Long idCliente,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int cantidad) {
        return this.reportBankTransactionHandler.execute(idCliente, fechaInicio, fechaFin, pagina, cantidad);
    }
}
