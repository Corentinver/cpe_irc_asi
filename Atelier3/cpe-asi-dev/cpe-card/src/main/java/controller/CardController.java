package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pojo.Card;
import rest.CardRest;
import service.CardService;

public class CardController implements CardRest {
	
	@Autowired
	CardService cardService;

	@Override
	public ResponseEntity<List<Card>> getCollectionCardsByUser(Integer userId) {
		return new ResponseEntity<>(cardService.getCollectionCardsByUser(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Card>> getShopCardsByUser(Integer userId) {
		return new ResponseEntity<>(cardService.getShopCardsByUser(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Card> getCardById(Integer id) {
		return new ResponseEntity<>(cardService.getCardById(id), HttpStatus.OK);
	}
	
}