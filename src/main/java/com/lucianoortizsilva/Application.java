package com.lucianoortizsilva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EntityScan(basePackages = { "com.lucianoortizsilva.batch.model", "com.lucianoortizsilva.cadastro.model" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}