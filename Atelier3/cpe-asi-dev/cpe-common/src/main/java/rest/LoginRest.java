package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.UserGetDTO;
import dto.UserLoginDTO;
import pojo.user.User;

/**
 * 
 * @author Gouy Quentin
 * Interface CarRest pour un controller Login
 * Cet interface sera implémenté par une classe sera la représentation implementé du controller Login
 */
@RequestMapping(value = LoginRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface LoginRest {

	/*
	 * Definition des url de l'API pour le controller Login
	 */
	public static final String BASE_URL = "";
	public static final String LOGIN_USER_URL = "/login";
	public static final String LOGOUT_USER_URL = "/logout";
    
	/**
	 * Login d'un utilisateur et récupération de ces informations côté client
	 * @param userLogin
	 * @return UserGetDTO information utilisateur côté client 
	 */
    @RequestMapping(
    		value = LOGIN_USER_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<UserGetDTO> login(@RequestBody UserLoginDTO userLogin);
    
	/**
	 * Deconnexion d'un utilisateur
	 * @return HttpStatus si déconnecté 
	 */
    @RequestMapping(
    		value = LOGOUT_USER_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<HttpStatus> logout();
    
}

