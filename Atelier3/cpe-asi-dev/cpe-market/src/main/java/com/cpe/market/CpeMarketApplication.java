package com.cpe.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Gouy Quentin
 * Classe Application pour le lancement et le chargement des différents composants de notre application
 *
 */
@SpringBootApplication
//Dossier à scan
@ComponentScan(basePackages = {"config", "pojo", "service", "controller", "rest"})
public class CpeMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpeMarketApplication.class, args);
	}

}
