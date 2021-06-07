package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.MarketDTO;


@RequestMapping(value = MarketRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface MarketRest {

    static final String BASE_URL = "/market";
    static final String SELL_CARD_URL = "/sell";
    static final String BUY_CARD_URL = "/buy";
    
    @RequestMapping(
    		value = SELL_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> sellCard(@RequestBody MarketDTO market);
    
    
    @RequestMapping(
    		value = BUY_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> buyCard(@RequestBody MarketDTO market);
}

