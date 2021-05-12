package com.cpe.card.card.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	public Card getCardById(int cardId) {
		Optional<Card> optionalCard = cardRepository.findById(cardId);
		return optionalCard.get();
	}
}
