package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import dto.MarketDTO;
import pojo.user.User;
import pojo.card.Card;
import rest.UserRest;
import rest.CardRest;

/**
 * 
 * @author Gouy Quentin
 * Class Service Market utilisant la class jpa pour récupérer des cartes.
 * Ajout des cartes par l'outil de Postgres Sql, pas d'ajout via l'application
 */
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

		return response;
	}

	public boolean sellCard(MarketDTO market) {
		boolean response = false;
		
		User user = this.getUser(market.getId());
		Card card = this.getCard(market.getCardId());
		
		Integer userId = user.getUserId();
		Integer cardId = card.getId();
		Double amount = card.getPrice();

		this.changeUserCard(userId, cardId, "REMOVE");
		this.changeUserMoney(userId, amount, "ADD");

		response = true;

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
