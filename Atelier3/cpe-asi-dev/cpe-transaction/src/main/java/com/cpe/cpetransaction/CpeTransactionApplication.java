package com.cpe.cpetransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Poulard Antonin
 * Classe Application pour le lancement et le chargement des différents composants de notre application
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = {"config", "pojo", "service", "controller", "rest"})
public class CpeTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpeTransactionApplication.class, args);
	}
}
