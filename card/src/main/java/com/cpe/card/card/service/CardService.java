package com.cpe.card.card.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.card.card.dto.Card;
import com.cpe.card.card.dto.OwnedCard;
import com.cpe.card.card.repository.CardRepository;
import com.cpe.card.card.repository.OwnedCardRepository;

@Service
public class CardService {

	@Autowired
	private OwnedCardRepository ownedCardRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UserService userService;

	public List<Card> getOwnedCardsByUser(int id) {
		List<OwnedCard> listOwnedCards = ownedCardRepository.findOwnedCard(id);
		List<Card> listCards = new ArrayList<>();
		
		listOwnedCards.forEach(ownedCard -> {
			Optional<Card> card = cardRepository.findById(ownedCard.getCardId());
			if (card.isPresent()) {
				listCards.add(card.get());
			}
		});
		
		return listCards;
	}

	public List<Card> getUnownedCardsByUser(int id) {
		List<OwnedCard> listOwnedCards = ownedCardRepository.findOwnedCard(id);
		List<Integer> listIdOwnedCards = new ArrayList<Integer>();
		listIdOwnedCards.removeAll(arg0)
		
		listOwnedCards.forEach(ownedCard -> {
			listIdOwnedCards.add(ownedCard.getCardId());
		});
		
		List<Card> listAllCards = cardRepository.findAll();
		
		return listAllCards.stream()
			.filter(card -> !listIdOwnedCards.contains(card.getId()))
			.collect(Collectors.toList());
	}

	public Boolean sellCard(OwnedCard ownedCard) {
		ownedCardRepository.delete(ownedCard);
	}

	public Boolean buyCard(OwnedCard ownedCard) {
		Boolean returnValue = false;
		Optional<Card> optionalCard = cardRepository.findById(ownedCard.cardId);
		if(optionalCard.isPresent()) {
			if(userService.canBuy(ownedCard.userId, optionalCard.get().getPrice())) {
				ownedCardRepository.save(ownedCard);
				returnValue = true;
			}	
		}
		else {
			// throw or false; returnValue = false;
		}
		
		return returnValue;
	}

}
