package com.example.finance_nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FinanceNosqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceNosqlApplication.class, args);
	}

}
