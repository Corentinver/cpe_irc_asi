package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import pojo.Card;
import rest.CardRest;
import service.CardService;

@CrossOrigin
@RestController
public class CardController implements CardRest {
	
	@Autowired
	CardService cardService;

	@Override
	public ResponseEntity<List<Card>> getCollectionCardsByUser(Integer userId) {
		return new ResponseEntity<List<Card>>(cardService.getCollectionCardsByUser(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Card>> getShopCardsByUser(Integer userId) {
		return new ResponseEntity<List<Card>>(cardService.getShopCardsByUser(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Card> getCardById(Integer id) {
		return new ResponseEntity<Card>(cardService.getCardById(id), HttpStatus.OK);
	}
	
}