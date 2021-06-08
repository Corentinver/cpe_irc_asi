package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import api.impl.CardImpl;
import api.impl.UserImpl;
import dto.MarketDTO;
import dto.UserGetDTO;
import pojo.Card;
import pojo.User;

@Service
public class MarketService {
	
	@Autowired
	private UserImpl userImpl;
	
	private CardImpl cardImpl;

	public boolean buyCard(MarketDTO market) {
		boolean response = false;
		ResponseEntity<UserGetDTO> userResponse = userImpl.getUserById(market.getId());
		ResponseEntity<Card> cardResponse = cardImpl.getCardById(market.getCardId());
		if(userResponse.getStatusCode() == HttpStatus.OK && cardResponse.getStatusCode() == HttpStatus.OK) {
			if(userResponse.getBody().getMoney() >= cardResponse.getBody().getPrice()) {
				userImpl.addCard(market.getId(), market.getCardId());
				userImpl.removeMoney(market.getId(), cardResponse.getBody().getPrice());
				response = true;
			}
		}
		
		return response;
	}

	public boolean sellCard(MarketDTO market) {
		boolean response = false;
		ResponseEntity<UserGetDTO> userResponse = userImpl.getUserById(market.getId());
		ResponseEntity<Card> cardResponse = cardImpl.getCardById(market.getCardId());
		if(userResponse.getStatusCode() == HttpStatus.OK && cardResponse.getStatusCode() == HttpStatus.OK) {
			userImpl.removeCard(market.getId(), market.getCardId());
			userImpl.addMoney(market.getId(), cardResponse.getBody().getPrice());
			response = true;
		}
		
		return response;
	}

	
}
