package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dto.MarketDTO;
import rest.MarketRest;
import service.MarketService;


@CrossOrigin
@RestController
public class MarketController implements MarketRest {

	@Autowired
	MarketService marketService;
	
	@Override
	public ResponseEntity<HttpStatus> sellCard(MarketDTO market) {
		if (marketService.sellCard(market)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	}

	@Override
	public ResponseEntity<HttpStatus> buyCard(MarketDTO market) {
		if (marketService.buyCard(market)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		

}
