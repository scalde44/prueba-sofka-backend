package co.com.sofka.customers.adapter.event;

import co.com.sofka.customers.port.event.EventPublisher;
import co.com.sofka.customers.properties.QueueProperties;
import co.com.sofka.domain.exception.InvalidValueException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherRabbitMq implements EventPublisher {
    private static final String SERIALIZATION_ERROR = "Error serializando el mensaje";
    private final RabbitTemplate rabbitTemplate;
    private final QueueProperties queueProperties;
    private final ObjectMapper objectMapper;

    @Override
    public void publish(Object event) {
        String message;
        try {
            message = this.objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new InvalidValueException(SERIALIZATION_ERROR);
        }
        this.rabbitTemplate.convertAndSend(queueProperties.getExchange(), queueProperties.getRouting().getKey(), message);
    }
}
