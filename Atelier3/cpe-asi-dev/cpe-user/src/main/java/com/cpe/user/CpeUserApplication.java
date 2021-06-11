package com.cpe.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("pojo.user")
@ComponentScan(basePackages = {"pojo", "repository", "service", "controller"})
public class CpeUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpeUserApplication.class, args);
	}

}
