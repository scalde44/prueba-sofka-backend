package co.com.sofka.customers.port.event;

public interface EventPublisher {
    void publish(Object event);
}
