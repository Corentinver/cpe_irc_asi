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
public interface UserRest {

	public static final String BASE_URL = "/user";
	public static final String CREATE_USER_URL = "/create";
	public static final String ADD_MONEY_URL = "/{id}/add/money";
	public static final String REMOVE_MONEY_URL = "/{id}/remove/money";
	public static final String ADD_CARD_URL = "/{id}/add/card";
	public static final String REMOVE_CARD_URL = "/{id}/remove/card";
	public static final String USER_URL = "/{id}";
    
    
    @RequestMapping(
    		value = ADD_MONEY_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<Double> addMoney(@PathVariable Integer userId, @RequestBody double amount);
    
    
    @RequestMapping(
    		value = REMOVE_MONEY_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<Double> removeMoney(@PathVariable Integer userId, @RequestBody double amount);
    
    
    @RequestMapping(
    		value = ADD_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> addCard(@PathVariable Integer userId, @RequestBody Integer cardId);
    
    
    @RequestMapping(
    		value = REMOVE_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> removeCard(@PathVariable Integer userId, @RequestBody Integer cardId);

    
    @RequestMapping(
    		value = USER_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<User> getUserById(@PathVariable Integer userId);
    
    
    @RequestMapping(
    		value = CREATE_USER_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<UserDTO> createUser(@RequestBody UserRegister userRegister);
    
}

