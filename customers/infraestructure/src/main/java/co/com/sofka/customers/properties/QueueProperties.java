package co.com.sofka.customers.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "queue-customer")
public class QueueProperties {
    private String exchange;
    private String name;
    private Routing routing;

    @Getter
    @Setter
    public static class Routing {
        private String key;
    }
}
