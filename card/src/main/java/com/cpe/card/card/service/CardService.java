package com.cpe.card.card.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.card.card.pojo.Card;
import com.cpe.card.card.pojo.User;
import com.cpe.card.card.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UserService userService;
	
	public List<Card> getCollectionCardsByUser(int id) {
		User user = userService.findById(id);
		return user.getCards();
	}

	public List<Card> getShopCardsByUser(int id) {
		User user = userService.findById(id);
		List<Card> listOwnedCards = user.getCards();
		List<Card> listAllCards = cardRepository.findAll();
		listAllCards.removeAll(listOwnedCards);
		return listAllCards;
	}

	public Boolean buyCard(int userId, int cardId) {
		Boolean returnValue = false;
		User user = userService.findById(userId);
		Optional<Card> optionalCard = cardRepository.findById(cardId);
		if(optionalCard.isPresent()) {
			if(userService.canBuy(userId, optionalCard.get().getPrice())) {
				userService.buy(userId,optionalCard.get().getPrice());
				user.addCard(optionalCard.get());
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
		Optional<Card> optionalCard = cardRepository.findById(cardId);
		if(optionalCard.isPresent()) {
			userService.sell(userId, optionalCard.get().getPrice());
			user.removeCard(optionalCard.get());
			returnValue = true;
		}
		else {
			// throw or false; returnValue = false;
		}
		
		return returnValue;
	}



}
