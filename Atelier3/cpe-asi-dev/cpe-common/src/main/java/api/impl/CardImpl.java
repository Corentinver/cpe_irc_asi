package api.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import pojo.Card;
import pojo.User;
import rest.CardRest;
import rest.UserRest;

@Component
public class CardImpl implements CardRest {

	@Autowired
	RestTemplate restTemplate;
	
    public static final String hostCard = "localhost:8082" + CardRest.BASE_URL;
	
	public ResponseEntity<List<Card>> getCollectionCardsByUser(Integer userId) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostCard).path(CardRest.COLLECTION).buildAndExpand(userId);
		ResponseEntity<Card[]> cards = restTemplate.getForEntity(uriComponents.toUri(), Card[].class);
		return new ResponseEntity<List<Card>>(Arrays.asList(cards.getBody()), cards.getStatusCode());
	}

	public ResponseEntity<List<Card>> getShopCardsByUser(Integer userId) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostCard).path(CardRest.SHOP).buildAndExpand(userId);
		ResponseEntity<Card[]> cards = restTemplate.getForEntity(uriComponents.toUri(), Card[].class);
		return new ResponseEntity<List<Card>>(Arrays.asList(cards.getBody()), cards.getStatusCode());
	}

	public ResponseEntity<Card> getCardById(Integer id) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostCard).path(CardRest.CARD_URL).buildAndExpand(id);
		return restTemplate.getForEntity(uriComponents.toUri(), Card.class);
	}

	public ResponseEntity<List<Card>> getAllCards() {
		// TODO Auto-generated method stub
		return null;
	}

}
