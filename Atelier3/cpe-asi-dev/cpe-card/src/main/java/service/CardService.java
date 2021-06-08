package service;

import java.util.ArrayList;
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
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<Card> getCollectionCardsByUser(int userId) {
		String url = UserRest.SERVER + UserRest.BASE_URL + UserRest.USER_URL;
		url = url.replace("{id}", String.valueOf(userId));
		
		User user = restTemplate.getForObject(url, User.class);

		return this.getCardsFromUser(user);
	}

	public List<Card> getShopCardsByUser(int userId) {
		String url = UserRest.SERVER + UserRest.BASE_URL + UserRest.USER_URL;
		url = url.replace("{id}", String.valueOf(userId));
		
		User user = restTemplate.getForObject(url, User.class);
		
		List<Card> ownedCards = this.getCardsFromUser(user);
		List<Card> allCards = cardRepository.findAll();
		
		allCards.removeAll(ownedCards);
		
		return allCards;
	}
	
	public Card getCardById(int id) {
		return cardRepository.findById(id).get();
	}
	
	public List<Card> getAllCards() {
		return cardRepository.findAll();
	}
	
	private List<Card> getCardsFromUser(User user){
		List<Card> cards = new ArrayList<Card>();
		for(Integer cardId : user.getCards()) {
			Card card = this.getCardById(cardId);
			if(card != null)
				cards.add(card);
		}
		
		return cards;
	}
}
