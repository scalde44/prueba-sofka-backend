package co.com.sofka.accounts.event;

import co.com.sofka.accounts.command.CustomerCommand;
import co.com.sofka.accounts.command.handler.CreateDefaultAccountHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEventListener {
    private final CreateDefaultAccountHandler createDefaultAccountHandler;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${queue-customer.name}")
    public void handleCustomerCreatedEvent(String message) throws JsonProcessingException {
        var customerCommand = this.objectMapper.readValue(message, CustomerCommand.class);
        this.createDefaultAccountHandler.execute(customerCommand);
    }
}
