package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pojo.Card;
import pojo.User;
import repository.CardRepository;


@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public List<Card> getCollectionCardsByUser(int id) {
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

	public List<Card> getShopCardsByUser(int id) {
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
	
	public Card getCardById(int cardId) {
		return cardRepository.findById(cardId).get();
	}
}
