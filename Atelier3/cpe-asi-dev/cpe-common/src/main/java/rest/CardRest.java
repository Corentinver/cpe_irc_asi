package rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.Card;

@RequestMapping(value = CardRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface CardRest {

	public static final String BASE_URL = "/cards";
	public static final String COLLECTION = "/collection/{userId}";
	public static final String SHOP = "/shop/{userId}";
	public static final String CARD_URL = "/{id}";
    
    @RequestMapping(
    		value = COLLECTION,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Card>> getCollectionCardsByUser(@PathVariable(name="userId") Integer userId);
    
    @RequestMapping(
    		value = SHOP,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Card>> getShopCardsByUser(@PathVariable(name="userId") Integer userId);
    
    @RequestMapping(
    		value = CARD_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<Card> getCardById(@PathVariable(name="id") Integer id);
}
