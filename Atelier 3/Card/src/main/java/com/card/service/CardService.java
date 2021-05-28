package com.card.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.repository.CardRepository;

import pojo.Card;
import pojo.User;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	//private UserService userService;
	
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
	
	public Card getCardById(int cardId) {
		System.out.println("card id : " + cardId);
		Optional<Card> optionalCard = cardRepository.findById(cardId);
		return optionalCard.get();
	}
}
