package com.cpe.card.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.card.card.repository.CardRepository;
import com.cpe.card.card.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
		
	@Autowired CardService cardService;

	@GetMapping("/collection/{id}")
	public ResponseEntity<?> getOwnedCardsByUser(@RequestParam int id) {
		return new ResponseEntity<>(cardService.getOwnedCardsByUser(id), HttpStatus.OK);
	}
	
	@GetMapping("/shop/{id}")
	public ResponseEntity<?> getUnownedCards(@RequestParam int id) {
		return new ResponseEntity<>(cardService.getUnownedCardsByUser(id), HttpStatus.OK);
	}
			
	
}
