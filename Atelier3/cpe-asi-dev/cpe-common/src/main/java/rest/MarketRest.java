package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.MarketDTO;

/**
 * 
 * @author Gouy Quentin
 * Interface CarRest pour un controller Market
 * Cet interface sera implémenté par une classe sera la représentation implementé du controller Market
 */
@RequestMapping(value = MarketRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface MarketRest {

	/*
	 * Definition des url de l'API pour le controller Market
	 */
    public static final String BASE_URL = "/market";
    public static final String SELL_CARD_URL = "/sell";
    public static final String BUY_CARD_URL = "/buy";
    
	/**
	 * Vente d'une carte par rapport à un utilisateur
	 * @param market
	 * @return HttpStatus vente ok
	 */
    @RequestMapping(
    		value = SELL_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> sellCard(@RequestBody MarketDTO market);
    
	/**
	 * Achat d'une carte par rapport à un utilisateur
	 * @param market
	 * @return HttpStatus achat ok
	 */
    @RequestMapping(
    		value = BUY_CARD_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> buyCard(@RequestBody MarketDTO market);
}

