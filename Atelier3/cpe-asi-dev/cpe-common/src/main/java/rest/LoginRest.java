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
 * Cet interface sera impl�ment� par une classe sera la repr�sentation implement� du controller Login
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
	 * Login d'un utilisateur et r�cup�ration de ces informations c�t� client
	 * @param userLogin
	 * @return UserGetDTO information utilisateur c�t� client 
	 */
    @RequestMapping(
    		value = LOGIN_USER_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<UserGetDTO> login(@RequestBody UserLoginDTO userLogin);
    
	/**
	 * Deconnexion d'un utilisateur
	 * @return HttpStatus si d�connect� 
	 */
    @RequestMapping(
    		value = LOGOUT_USER_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<HttpStatus> logout();
    
}

