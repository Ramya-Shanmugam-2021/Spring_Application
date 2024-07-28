package com.microservices.spring.Microservices_bankApp_serviceDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesBankAppServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBankAppServiceDiscoveryApplication.class, args);
	}

}
