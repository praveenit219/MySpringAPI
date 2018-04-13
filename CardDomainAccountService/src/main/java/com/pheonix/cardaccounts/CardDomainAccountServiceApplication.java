package com.pheonix.cardaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CardDomainAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardDomainAccountServiceApplication.class, args);
	}
}
