package co.com.sofka.customers.config;

import co.com.sofka.customers.properties.QueueProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {
    private final QueueProperties queueProperties;


    @Bean
    public TopicExchange exchangeCustomer() {
        return new TopicExchange(queueProperties.getExchange());
    }

    @Bean
    public Queue queueCustomer() {
        return new Queue(queueProperties.getName());
    }

    @Bean
    public Binding bindingCustomer() {
        return BindingBuilder
                .bind(queueCustomer())
                .to(exchangeCustomer())
                .with(queueProperties.getRouting().getKey());
    }
}