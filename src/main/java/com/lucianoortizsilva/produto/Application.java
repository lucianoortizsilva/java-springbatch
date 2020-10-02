package com.lucianoortizsilva.produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EntityScan(basePackages = { "com.lucianoortizsilva.produto.batch.entity", "com.lucianoortizsilva.produto.cadastro.entity" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}