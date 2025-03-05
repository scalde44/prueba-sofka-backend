package co.com.sofka.customers.config;

import co.com.sofka.customers.properties.QueueProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

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

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(1000);
        backOffPolicy.setMultiplier(2.0);
        backOffPolicy.setMaxInterval(10000);

        retryTemplate.setBackOffPolicy(backOffPolicy);
        factory.setRetryTemplate(retryTemplate);
        return factory;
    }
}