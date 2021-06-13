package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UserGetDTO;
import dto.UserPostDTO;
import pojo.user.User;
import rest.UserRest;
import service.UserService;
import utils.MapStructMapperImpl;

/**
 * 
 * @author Gouy Quentin
 * Implementation des fonctions des url du controller User
 */
@CrossOrigin
@RestController
public class UserController implements UserRest {

	@Autowired
	private UserService userService;
	
	private MapStructMapperImpl mapper = new MapStructMapperImpl();

	/**
	 * Ajout d'argent lors d'une vente d'une carte par un utilisateur
	 * Fonction appelé depuis le service market
	 * @param userId Identifiant d'un utilisateur, amont Montant d'argent à ajouter
	 * @return Double montant 
	 */
	@Override
	public ResponseEntity<Double> addMoney(Integer userId, double amount) {
		return new ResponseEntity<Double>(userService.addMoney(userId, amount), HttpStatus.OK);
	}

	/**
	 * Retrait d'argent lors d'un achat d'une carte par un utilisateur
	 * Fonction appelé depuis le service market
	 * @param userId Identifiant d'un utilisateur, amont Montant d'argent à enlever
	 * @return Double montant 
	 */
	@Override
	public ResponseEntity<Double> removeMoney(Integer userId, double amount) {
		return new ResponseEntity<Double>(userService.removeMoney(userId, amount), HttpStatus.OK);
	}

	/**
	 * Ajout de la carte lors d'un achat par un utilisateur
	 * Fonction appelé depuis le service market
	 * @param userId Identifiant d'un utilisateur, cardId carte à ajouter à un utilisateur
	 * @return HttpStatus carte acheté 
	 */
	@Override
	public ResponseEntity<HttpStatus> addCard(Integer userId, Integer cardId) {
		boolean result = userService.addCard(userId, cardId);
		// Renvoi carte acheté ok sinon erreur interne server
		if(result) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retrait de la carte lors d'une vente par un utilisateur
	 * Fonction appelé depuis le service market
	 * @param userId Identifiant d'un utilisateur, cardId carte à enlever à un utilisateur
	 * @return HttpStatus carte vendue 
	 */
	@Override
	public ResponseEntity<HttpStatus> removeCard(Integer userId, Integer cardId) {
		boolean result = userService.removeCard(userId, cardId);
		if(result) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Recupération des informations d'un utilisateur avec son identifiant
	 * Fonction appelé par l'application interne
	 * @param userId
	 * @return User
	 */
	@Override
	public ResponseEntity<User> getUserById(Integer userId) {
		User user = userService.findById(userId);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Enregistrement d'un utilisateur depuis le formulaire côté client
	 * @param userPostDTO informations envoyés par l'utilisateur saisi dans le formulaire d'enregistrement
	 * @return UserGetDTO informations utilisateur côté client
	 */
	@Override
	public ResponseEntity<UserGetDTO> createUser(UserPostDTO userPostDTO) {
		// Conversion d'un user
		User user = mapper.userPostDTOtoUser(userPostDTO);
		// Enregistrement de l'utilisateur
		User userCreated = userService.createUser(user);
		// Renvoi de l'utilsateur vers le côté client sinon renvoi error interne server
		if (userCreated != null) {
			return new ResponseEntity<UserGetDTO>(mapper.userToUserGetDTO(userCreated), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}