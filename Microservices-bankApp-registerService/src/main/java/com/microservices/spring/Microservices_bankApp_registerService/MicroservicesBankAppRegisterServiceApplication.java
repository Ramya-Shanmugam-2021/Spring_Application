package com.microservices.spring.Microservices_bankApp_registerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(scanBasePackages = "com.microservices.spring.Microservices_bankApp_registerService")
@ComponentScan("com.microservices.spring.Microservices_bankApp_registerService.exception,com.microservices.spring.Microservices_bankApp_registerService.config")
public class MicroservicesBankAppRegisterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBankAppRegisterServiceApplication.class, args);
	}

}
