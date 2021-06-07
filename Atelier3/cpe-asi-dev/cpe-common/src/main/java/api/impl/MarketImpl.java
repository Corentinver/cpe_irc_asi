package api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import dto.MarketDTO;
import rest.MarketRest;

public class MarketImpl implements MarketRest {

	@Autowired
	RestTemplate restTemplate;
	
    public static final String hostMarket = "localhost:8081" + MarketRest.BASE_URL;
	
	public ResponseEntity<HttpStatus> sellCard(MarketDTO market) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostMarket).path(MarketRest.SELL_CARD_URL).build();
		return restTemplate.postForEntity(uriComponents.toUri(), market, HttpStatus.class);
	}

	public ResponseEntity<HttpStatus> buyCard(MarketDTO market) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostMarket).path(MarketRest.BUY_CARD_URL).build();
		return restTemplate.postForEntity(uriComponents.toUri(), market, HttpStatus.class);	}

}
