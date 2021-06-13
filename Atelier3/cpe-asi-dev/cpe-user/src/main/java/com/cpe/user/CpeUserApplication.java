package com.cpe.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@EntityScan("pojo.user")
//Dossier à scan
@ComponentScan(basePackages = {"pojo", "repository", "service", "controller"})
public class CpeUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpeUserApplication.class, args);
	}

}
