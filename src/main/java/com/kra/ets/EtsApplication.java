package com.kra.ets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.kra.ets")
@EnableJpaRepositories(basePackages = "com.kra.ets.model")
public class EtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtsApplication.class, args);
	}

}
