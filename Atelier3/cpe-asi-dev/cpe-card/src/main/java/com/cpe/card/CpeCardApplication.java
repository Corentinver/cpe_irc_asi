package com.cpe.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("pojo")
@ComponentScan(basePackages = {"pojo", "repository", "service", "controller", "rest"})
public class CpeCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpeCardApplication.class, args);
	}

}
