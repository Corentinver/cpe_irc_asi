package com.cpe.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Gouy Quentin
 * Classe Application pour le lancement et le chargement des différents composants de notre application
 *
 */
@SpringBootApplication
//Dossier pour notre base de données, liaison avec jpa hibernate
@EnableJpaRepositories("repository")
//Dossier pour nos tables de la base de données
@EntityScan({"pojo.room"})
//Dossier à scan
@ComponentScan(basePackages = {"config", "pojo", "repository", "service", "controller", "rest"})
public class CpeRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpeRoomApplication.class, args);
	}

}
