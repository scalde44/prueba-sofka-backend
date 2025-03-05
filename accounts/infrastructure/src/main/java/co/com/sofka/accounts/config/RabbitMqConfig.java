package co.com.sofka.accounts.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Value("${queue-customer.name}")
    private String queueName;

    @Bean
    public Queue queueCustomer() {
        return new Queue(queueName, true);
    }
}
