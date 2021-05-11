package com.cpe.card.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.card.card.dto.OwnedCard;
import com.cpe.card.card.service.CardService;

@RestController
@RequestMapping("/market")
public class MarketController {
	
	@Autowired CardService cardService;

	@GetMapping("/sell/{cardId}/{userId}")
	public ResponseEntity<?> sellCard(@RequestParam int cardId, @RequestParam int userId) {
		return new ResponseEntity<>(cardService.sellCard(userId, cardId), HttpStatus.OK);
	}
	
	@GetMapping("/buy/{cardId}/{userId}")
	public ResponseEntity<?> buyCard(@RequestParam int cardId, @RequestParam int userId) {
		return new ResponseEntity<>(cardService.buyCard(userId, cardId), HttpStatus.OK);
	}
}
