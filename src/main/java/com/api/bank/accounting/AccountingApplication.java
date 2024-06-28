package com.api.bank.accounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AccountingApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountingApplication.class, args);
	}
}
