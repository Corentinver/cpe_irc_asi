package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pojo.Card;
import pojo.User;
import repository.CardRepository;
import api.impl.UserImpl;


@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	UserImpl userImpl;
	
	public List<Card> getCollectionCardsByUser(int userId) {
		ResponseEntity response = userImpl.getUserById(userId);
		
		// TODO : il ne devrait pas y avoir d'implémentation des controlleurs dans le common.
		// On devrait plutôt passer par les interfaces du common.
		
		if(response.getStatusCodeValue() != 200) {
			return null;
		}
		
		User user = (User) response.getBody();
		System.out.print(user);
		/*
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("/users/" + id, User.class);
		return user.getCards();
		*/
		
		/*
		User user = userService.findById(id);
		return user.getCards();*/
		return null;
	}

	public List<Card> getShopCardsByUser(int userId) {
		
		/*
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://localhost:8080/user/" + userId, User.class);
		System.out.print(user);
		
		/*
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("/users/" + id, User.class);
		List<Card> listOwnedCards = user.getCards();
		List<Card> listAllCards = cardRepository.findAll();
		listAllCards.removeAll(listOwnedCards);
		return listAllCards;
		*/
		
		/*
		User user = userService.findById(id);
		List<Card> listOwnedCards = user.getCards();
		List<Card> listAllCards = cardRepository.findAll();
		listAllCards.removeAll(listOwnedCards);
		return listAllCards;*/
		return null;
	}
	
	public Card getCardById(int id) {
		return cardRepository.findById(id).get();
	}
}
