package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.UserDTO;
import dto.UserRegister;
import pojo.User;


@RequestMapping(value = UserRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface LoginRest {

	public static final String BASE_URL = "";
	public static final String LOGIN_USER_URL = "/login";
	public static final String LOGOUT_USER_URL = "/logout";
	public static final String REMOVE_MONEY_URL = "/{id}/remove/money";
	public static final String ADD_CARD_URL = "/{id}/add/card";
	public static final String REMOVE_CARD_URL = "/{id}/remove/card";
	public static final String USER_URL = "/{id}";
    
    
    @RequestMapping(
    		value = USER_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<UserDTO> login(@RequestBody UserRegister userRegister);
    
    
    @RequestMapping(
    		value = LOGOUT_USER_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<HttpStatus> logout();
    
}

