package com.card.Card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardApplication {

	public static void main(String[] args) {
		UserDTO user = new UserDTO();
		SpringApplication.run(CardApplication.class, args);
	}

}
