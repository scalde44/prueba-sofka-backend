package co.com.sofka.accounts.adapter.client;

import co.com.sofka.accounts.model.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-customers")
public interface CustomerClient {
    @GetMapping("/api/v1/clientes/{id}")
    CustomerDto findCustomer(@PathVariable Long id);
}
