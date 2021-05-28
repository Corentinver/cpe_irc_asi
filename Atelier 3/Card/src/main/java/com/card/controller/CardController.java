package com.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.card.service.CardService;

@CrossOrigin
@RestController
@RequestMapping("/cards")
public class CardController {
		
	@Autowired CardService cardService;

	@GetMapping("/collection")
	public ResponseEntity<?> getOwnedCardsByUser(@RequestParam int id) {
		return new ResponseEntity<>(cardService.getCollectionCardsByUser(id), HttpStatus.OK);
	}
	
	@GetMapping("/shop")
	public ResponseEntity<?> getUnownedCards(@RequestParam int id) {
		return new ResponseEntity<>(cardService.getShopCardsByUser(id), HttpStatus.OK);
	}
}