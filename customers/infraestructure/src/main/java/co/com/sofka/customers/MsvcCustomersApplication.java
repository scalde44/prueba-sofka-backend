package co.com.sofka.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"co.com.sofka"})
@SpringBootApplication
public class MsvcCustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcCustomersApplication.class, args);
	}

}
