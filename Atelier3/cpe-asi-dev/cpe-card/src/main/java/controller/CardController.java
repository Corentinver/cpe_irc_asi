package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rest.CardRest;
import service.CardService;

public class CardController implements CardRest {
	
	@Autowired
	CardService cardService;

	@Override
	public ResponseEntity<?> getCollectionCardsByUser(Integer userId) {
		return new ResponseEntity<>(cardService.getCollectionCardsByUser(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getShopCardsByUser(Integer userId) {
		return new ResponseEntity<>(cardService.getShopCardsByUser(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getCardById(Integer id) {
		return new ResponseEntity<>(cardService.getCollectionCardsByUser(id), HttpStatus.OK);
	}
	
}