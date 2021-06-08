package service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import dto.MarketDTO;
import pojo.User;
import pojo.Card;
import rest.UserRest;
import rest.CardRest;

@Service
public class MarketService {
	
	private RestTemplate restTemplate = new RestTemplate();

	public boolean buyCard(MarketDTO market) {
		boolean response = false;
		
		User user = this.getUser(market.getId());
		Card card = this.getCard(market.getCardId());
		
		Integer userId = user.getUserId();
		Integer cardId = card.getId();
		Double amount = card.getPrice();

		if(user.getMoney() >= card.getPrice()) {
			this.changeUserCard(userId, cardId, "ADD");
			this.changeUserMoney(userId, amount, "REMOVE");

			response = true;
		}
		
		/*
		boolean response = false;
		ResponseEntity<User> userResponse = userImpl.getUserById(market.getId());
		ResponseEntity<Card> cardResponse = cardImpl.getCardById(market.getCardId());
		if(userResponse.getStatusCode() == HttpStatus.OK && cardResponse.getStatusCode() == HttpStatus.OK) {
			if(userResponse.getBody().getMoney() >= cardResponse.getBody().getPrice()) {
				userImpl.addCard(market.getId(), market.getCardId());
				userImpl.removeMoney(market.getId(), cardResponse.getBody().getPrice());
				response = true;
			}
		}
		*/
		
		return response;
	}

	public boolean sellCard(MarketDTO market) {
		boolean response = false;
		
		/*
		ResponseEntity<User> userResponse = userImpl.getUserById(market.getId());
		ResponseEntity<Card> cardResponse = cardImpl.getCardById(market.getCardId());
		if(userResponse.getStatusCode() == HttpStatus.OK && cardResponse.getStatusCode() == HttpStatus.OK) {
			userImpl.removeCard(market.getId(), market.getCardId());
			userImpl.addMoney(market.getId(), cardResponse.getBody().getPrice());
			response = true;
		}
		*/
		
		return response;
	}

	private User getUser(Integer id) {
		String url = UserRest.SERVER + UserRest.BASE_URL + UserRest.USER_URL;
		url = url.replace("{id}", String.valueOf(id));
		
		return restTemplate.getForObject(url, User.class);
	}
	
	private Card getCard(Integer id) {
		String url = CardRest.SERVER + CardRest.BASE_URL + CardRest.CARD_URL;
		url = url.replace("{id}", String.valueOf(id));
		
		return restTemplate.getForObject(url, Card.class);
	}
	
	private void changeUserCard(Integer userId, Integer cardId, String action) {
		String url = "";

		if(action == "ADD") {
			url = UserRest.SERVER + UserRest.BASE_URL + UserRest.ADD_CARD_URL;
		} else if(action == "REMOVE") {
			url = UserRest.SERVER + UserRest.BASE_URL + UserRest.REMOVE_CARD_URL;
		}
		
		url = url.replace("{id}", String.valueOf(userId));
		url = url.replace("{cardId}", String.valueOf(cardId));
		
		restTemplate.postForObject(url, null, HttpStatus.class);
	}
	
	private void changeUserMoney(Integer userId, Double amount, String action) {
		String url = "";

		if(action == "ADD") {
			url = UserRest.SERVER + UserRest.BASE_URL + UserRest.ADD_MONEY_URL;
		} else if(action == "REMOVE") {
			url = UserRest.SERVER + UserRest.BASE_URL + UserRest.REMOVE_MONEY_URL;
		}
		
		url = url.replace("{id}", String.valueOf(userId));
		url = url.replace("{amount}", String.valueOf(amount));
		
		restTemplate.postForObject(url, null, Double.class);
	}
}
