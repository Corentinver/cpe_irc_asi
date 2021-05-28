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


@RequestMapping(value = UserRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserRest {

    String BASE_URL = "/user";
    String CREATE_USER_URL = "/create";
    String ADD_MONEY_URL = "/{id}/add/money/{amount}";
    String REMOVE_MONEY_URL = "/{id}/remove/money/{amount}";
    String ADD_CARD_URL = "/{id}/add/card/{cardId}";
    String REMOVE_CARD_URL = "/{id}/remove/card/{cardId}";
    String USER_URL = "/{id}";
    
    
    @RequestMapping(
    		value = ADD_MONEY_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<Double> addMoney(@PathVariable Integer id, @PathVariable double amount);
    
    
    @RequestMapping(
    		value = REMOVE_MONEY_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<Double> removeMoney(@PathVariable Integer id, @PathVariable double amount);
    
    
    @RequestMapping(
    		value = ADD_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> addCard(@PathVariable Integer id, @PathVariable Integer cardId);
    
    
    @RequestMapping(
    		value = REMOVE_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> removeCard(@PathVariable Integer id, @PathVariable Integer cardId);

    
    @RequestMapping(
    		value = USER_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<Integer> getUserById(@PathVariable Integer id);
    
    
    @RequestMapping(
    		value = CREATE_USER_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<UserDTO> createUser(@RequestBody UserRegister userRegister);
    
}

