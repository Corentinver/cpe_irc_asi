package com.cpe.card.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.card.card.service.CardService;
import com.cpe.card.card.service.MarketService;

@CrossOrigin
@RestController
@RequestMapping("/market")
public class MarketController {
	
	@Autowired MarketService marketService;

	@GetMapping("/sell")
	public ResponseEntity<?> sellCard(@RequestParam int cardId, @RequestParam int userId) {
		return new ResponseEntity<>(marketService.sellCard(userId, cardId), HttpStatus.OK);
	}
	
	@GetMapping("/buy")
	public ResponseEntity<?> buyCard(@RequestParam int cardId, @RequestParam int userId) {
		return new ResponseEntity<>(marketService.buyCard(userId, cardId), HttpStatus.OK);
	}
}
