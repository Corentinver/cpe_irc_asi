package rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping(value = MarketRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface MarketRest {

    String BASE_URL = "/market";
    String SELL_CARD_URL = "/sell/{cardId}/{userId}";
    String BUY_CARD_URL = "/buy/{cardId}/{userId}";
    
    @RequestMapping(
    		value = SELL_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<?> sellCard(@PathVariable Integer cardId, @PathVariable Integer userId);
    
    
    @RequestMapping(
    		value = BUY_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<?> buyCard(@PathVariable Integer cardId, @PathVariable Integer userId);
}

