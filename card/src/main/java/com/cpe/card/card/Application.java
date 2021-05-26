package com.cpe.card.card;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.cpe.card.card.pojo.Affinity;
import com.cpe.card.card.pojo.Card;
import com.cpe.card.card.pojo.Family;
import com.cpe.card.card.pojo.User;
import com.cpe.card.card.repository.AffinityRepository;
import com.cpe.card.card.repository.CardRepository;
import com.cpe.card.card.repository.FamilyRepository;
import com.cpe.card.card.repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages= {"com.cpe.card.card.controller", "com.cpe.card.card.repository", "com.cpe.card.card.service"})
public class Application {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FamilyRepository familyRepository;
	
	@Autowired
	private AffinityRepository affinityRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		List<Affinity> affinities = new ArrayList<>();
		List<Family> families = new ArrayList<>();
		List<Card> cards = new ArrayList<>();
		return() -> {
			affinities.add(affinityRepository.save(new Affinity(null, "A")));
			affinities.add(affinityRepository.save(new Affinity(null, "B")));
			affinities.add(affinityRepository.save(new Affinity(null, "C")));
			affinities.add(affinityRepository.save(new Affinity(null, "D")));
			affinities.add(affinityRepository.save(new Affinity(null, "E")));
			
			families.add(familyRepository.save(new Family(null, "FamilyA")));
			families.add(familyRepository.save(new Family(null, "FamilyB")));
			families.add(familyRepository.save(new Family(null, "FamilyC")));
			families.add(familyRepository.save(new Family(null, "FamilyD")));
			families.add(familyRepository.save(new Family(null, "FamilyE")));
			
			cards.add(cardRepository.save(new Card(null, "Dracaufeu", "Gros dragon qui crache du feu", 2, 200, 34567.567, "path",families.get(0), affinities.get(1))));
			cards.add(cardRepository.save(new Card(null, "Bulbizarre", "Une plante avec des pattes",  4, 140, 347.567, "path",families.get(3), affinities.get(2))));
			cards.add(cardRepository.save(new Card(null, "Typhlosion", "Aïe ça brule", 2, 190, 3407.567, "path",families.get(1), affinities.get(1))));
			cards.add(cardRepository.save(new Card(null, "MewTwo", "Grille ta master ball pour le chopper (ou ton porte monnaie)", 80, 230, 34999907.567, "path",families.get(3), affinities.get(3))));
			
			userRepository.save(new User(null, "123456", "Vince", "Vincent", 99999999999999., cards));
			userRepository.save(new User(null, "azerty", "Quentin", "Gouy", 9999., cards));
			userRepository.save(new User(null, "password", "Corentin", "Vergnon", 99999999999., cards));
			userRepository.save(new User(null, "secure", "Antonin", "Poulard", 0., cards));	
		};
	}
}
