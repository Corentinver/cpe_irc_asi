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
import com.cpe.card.card.repository.CardRepository;
import com.cpe.card.card.repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages= {"com.cpe.card.card.controller", "com.cpe.card.card.repository", "com.cpe.card.card.service"})
public class Application {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
