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

    String BASE_URL = "/cards";
    String COLLECTION = "/collection/{userId}";
    String SHOP = "/shop/{userId}";
    String CARD_URL = "/{id}";
    
    @RequestMapping(
    		value = COLLECTION,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Card>> getCollectionCardsByUser(@PathVariable Integer userId);
    
    @RequestMapping(
    		value = SHOP,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Card>> getShopCardsByUser(@PathVariable Integer userId);
    
    @RequestMapping(
    		value = CARD_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<Card> getCardById(@PathVariable Integer id);
}
