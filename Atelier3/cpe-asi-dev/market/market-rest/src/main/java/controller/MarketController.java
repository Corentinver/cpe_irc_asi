package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import rest.MarketRest;


@CrossOrigin
@RestController
public class MarketController implements MarketRest {

	@Override
	public ResponseEntity<?> sellCard(Integer cardId, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> buyCard(Integer cardId, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
		

}
