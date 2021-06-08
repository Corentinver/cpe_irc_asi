package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pojo.Card;
import pojo.User;
import repository.CardRepository;
import rest.UserRest;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;

	private UserRest userRest;
	
	public List<Card> getCollectionCardsByUser(int userId) {
		RestTemplate restTemplate = new RestTemplate();

		String url = userRest.SERVER + userRest.BASE_URL + userRest.USER_URL;
		url = url.replace("{id}", String.valueOf(userId));
		
		User user = restTemplate.getForObject(url, User.class);
		
		System.out.print(user);
		System.out.print(user.getName());

		return new ArrayList<Card>();
	}

	public List<Card> getShopCardsByUser(int userId) {
		/*
		ResponseEntity response = userImpl.getUserById(userId);
		
		// TODO : il ne devrait pas y avoir d'implémentation des controlleurs dans le common.
		// On devrait plutôt passer par les interfaces du common.
		
		if(response.getStatusCodeValue() != 200) {
			return null;
		}
		
		User user = (User) response.getBody();
		List<Card> cards = getCardFromUser(user);
		List<Card> allCards = cardRepository.findAll();
		allCards.removeAll(cards);
		
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
		//return allCards;
		return null;
	}
	
	public Card getCardById(int id) {
		return cardRepository.findById(id).get();
	}
	
	private List<Card> getCardFromUser(User user){
		List<Card> cards = new ArrayList();
		List<Integer> cardsInt = Arrays.asList(user.getCards());
		cardsInt = new ArrayList(cardsInt);
		cardsInt.forEach(cardId -> {
			Card card = cardRepository.getById(cardId);
			if(card != null)
				cards.add(card);
		});
		
		return cards;
		
	}
}
