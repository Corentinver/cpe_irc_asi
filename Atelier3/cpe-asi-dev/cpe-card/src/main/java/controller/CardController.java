package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import pojo.card.Card;
import rest.CardRest;
import service.CardService;

/**
 * 
 * @author Gouy Quentin
 * Implementation des fonctions des url du controller Card
 */
@CrossOrigin
@RestController
public class CardController implements CardRest {
	
	@Autowired
	CardService cardService;

	/**
	 * Récupération des cartes d'un utilisateur
	 * @param userId Identifiant de l'utilisateur
	 * @return List<Card> 
	 */
	@Override
	public ResponseEntity<List<Card>> getCollectionCardsByUser(Integer userId) {
		return new ResponseEntity<List<Card>>(cardService.getCollectionCardsByUser(userId), HttpStatus.OK);
	}

    /**
	 * Récupération des cartes que l'utilisateur ne détient pas
	 * @param userId Identifiant de l'utilisateur
	 * @return List<Card> 
	 */
	@Override
	public ResponseEntity<List<Card>> getShopCardsByUser(Integer userId) {
		return new ResponseEntity<List<Card>>(cardService.getShopCardsByUser(userId), HttpStatus.OK);
	}

    /**
	 * Récupération d'une carte en particulier
	 * @param id Identifiant d'une carte
	 * @return Card 
	 */
	@Override
	public ResponseEntity<Card> getCardById(Integer id) {
		return new ResponseEntity<Card>(cardService.getCardById(id), HttpStatus.OK);
	}
	
    /**
	 * Récupération de toute les cartes
	 * @return List<Card>
	 */
	@Override
	public ResponseEntity<List<Card>> getAllCards() {
		return new ResponseEntity<List<Card>>(cardService.getAllCards(), HttpStatus.OK);
	}
}