package co.com.sofka.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"co.com.sofka"})
@SpringBootApplication
@EnableFeignClients
public class MsvcAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcAccountsApplication.class, args);
    }

}
