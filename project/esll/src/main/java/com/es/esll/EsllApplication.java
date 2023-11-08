package com.es.esll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.es" })
@EntityScan(basePackages = { "com.es" })
public class EsllApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsllApplication.class, args);
	}

}
