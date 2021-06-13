package rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.card.Card;

/**
 * 
 * @author Gouy Quentin
 * Interface CarRest pour un controller Card
 * Cet interface sera implémenté par une classe sera la représentation implementé du controller Card
 */
@RequestMapping(value = CardRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface CardRest {

	/*
	 * Definition des url de l'API pour le controller Card
	 */
	public static final String BASE_URL = "/cards";
	public static final String COLLECTION = "/collection/{userId}";
	public static final String SHOP = "/shop/{userId}";
	public static final String CARD_URL = "/{id}";
	
	/*
	 * Adresse et port de l'API Card defini pour l'utilsation interne de l'application
	 */
	public static final String SERVER = "http://localhost:8082";
    
	/**
	 * Récupération des cartes d'un utilisateur
	 * @param userId Identifiant de l'utilisateur
	 * @return List<Card> 
	 */
    @RequestMapping(
    		value = COLLECTION,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Card>> getCollectionCardsByUser(@PathVariable(name="userId") Integer userId);
    
    
    /**
	 * Récupération des cartes que l'utilisateur ne détient pas
	 * @param userId Identifiant de l'utilisateur
	 * @return List<Card> 
	 */
    @RequestMapping(
    		value = SHOP,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Card>> getShopCardsByUser(@PathVariable(name="userId") Integer userId);
    
    /**
	 * Récupération d'une carte en particulier
	 * @param id Identifiant d'une carte
	 * @return Card 
	 */
    @RequestMapping(
    		value = CARD_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<Card> getCardById(@PathVariable(name="id") Integer id);
    
    /**
	 * Récupération de toute les cartes
	 * @return List<Card>
	 */
    @RequestMapping(
    		value = "",
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Card>> getAllCards();
}
