package com.cpe.card.card.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.card.card.pojo.Card;
import com.cpe.card.card.pojo.User;

@Service
public class MarketService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CardService cardService;
	
	public Boolean buyCard(int userId, int cardId) {
		Boolean returnValue = false;
		User user = userService.findById(userId);
		Card card = cardService.getCardById(cardId);
		if(card != null) {
			if(userService.canBuy(userId, card.getPrice())) {
				userService.buy(userId,card.getPrice());
				user.addCard(card);
				returnValue = true;
			}	
		}
		else {
			// throw or false; returnValue = false;
		}
		
		return returnValue;
	}
	
	public Boolean sellCard(int userId, int cardId) {
		Boolean returnValue = false;
		User user = userService.findById(userId);
		Card card = cardService.getCardById(cardId);
		if(card != null) {
			userService.sell(userId, card.getPrice());
			user.removeCard(card);
			returnValue = true;
		}
		else {
			// throw or false; returnValue = false;
		}
		
		return returnValue;
	}
}
