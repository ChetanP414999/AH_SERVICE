package com.carloan.finance.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AhServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhServiceApplication.class, args);
	}

}
