package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.UserGetDTO;
import dto.UserPostDTO;
import pojo.user.User;

/**
 * 
 * @author Gouy Quentin
 * Interface CarRest pour un controller User
 * Cet interface sera implémenté par une classe sera la représentation implementé du controller User
 */
@RequestMapping(value = UserRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserRest {

	/*
	 * Definition des url de l'API pour le controller User
	 */
	public static final String BASE_URL = "/users";
	public static final String CREATE_USER_URL = "/create";
	public static final String ADD_MONEY_URL = "/{id}/add/money/{amount}";
	public static final String REMOVE_MONEY_URL = "/{id}/remove/money/{amount}";
	public static final String ADD_CARD_URL = "/{id}/add/card/{cardId}";
	public static final String REMOVE_CARD_URL = "/{id}/remove/card/{cardId}";
	public static final String USER_URL = "/{id}";
	
	/*
	 * Adresse et port de l'API User defini pour l'utilsation interne de l'application
	 */
	public static final String SERVER = "http://localhost:8080";
    
    
	/**
	 * Ajout d'argent lors d'une vente d'une carte par un utilisateur
	 * Route appelé depuis le service market
	 * @param userId Identifiant d'un utilisateur, amont Montant d'argent à ajouter
	 * @return Double montant 
	 */
    @RequestMapping(
    		value = ADD_MONEY_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<Double> addMoney(@PathVariable(name="id") Integer userId, @PathVariable(name="amount") double amount);
    
    
	/**
	 * Retrait d'argent lors d'un achat d'une carte par un utilisateur
	 * Route appelé depuis le service market
	 * @param userId Identifiant d'un utilisateur, amont Montant d'argent à enlever
	 * @return Double montant 
	 */
    @RequestMapping(
    		value = REMOVE_MONEY_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<Double> removeMoney(@PathVariable(name="id") Integer userId, @PathVariable(name="amount") double amount);
    
    
	/**
	 * Ajout de la carte lors d'un achat par un utilisateur
	 * Route appelé depuis le service market
	 * @param userId Identifiant d'un utilisateur, cardId carte à ajouter à un utilisateur
	 * @return HttpStatus carte acheté 
	 */
    @RequestMapping(
    		value = ADD_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> addCard(@PathVariable(name="id") Integer userId, @PathVariable(name="cardId") Integer cardId);
    
    
	/**
	 * Retrait de la carte lors d'une vente par un utilisateur
	 * Route appelé depuis le service market
	 * @param userId Identifiant d'un utilisateur, cardId carte à enlever à un utilisateur
	 * @return HttpStatus carte vendue 
	 */
    @RequestMapping(
    		value = REMOVE_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> removeCard(@PathVariable(name="id") Integer userId, @PathVariable(name="cardId") Integer cardId);

    
	/**
	 * Recupération des informations d'un utilisateur avec son identifiant
	 * Route appelé par l'application interne
	 * @param userId
	 * @return User
	 */
    @RequestMapping(
    		value = USER_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<User> getUserById(@PathVariable(name="id") Integer userId);
    
    
	/**
	 * Enregistrement d'un utilisateur depuis le formulaire côté client
	 * @param userPostDTO informations envoyés par l'utilisateur saisi dans le formulaire d'enregistrement
	 * @return UserGetDTO informations utilisateur côté client
	 */
    @RequestMapping(
    		value = CREATE_USER_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<UserGetDTO> createUser(@RequestBody UserPostDTO userPostDTO);
    
}

