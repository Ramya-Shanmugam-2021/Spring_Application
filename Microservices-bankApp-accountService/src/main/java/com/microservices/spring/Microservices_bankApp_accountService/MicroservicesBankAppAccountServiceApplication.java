package com.microservices.spring.Microservices_bankApp_accountService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicesBankAppAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBankAppAccountServiceApplication.class, args);
	}

}
