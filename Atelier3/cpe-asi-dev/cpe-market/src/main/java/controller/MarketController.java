package controller;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dto.MarketDTO;
import pojo.card.Card;
import rest.MarketRest;
import service.MarketService;


/**
 * 
 * @author Gouy Quentin
 * Implementation des fonctions des url du controller Market
 */
@CrossOrigin
@RestController
public class MarketController implements MarketRest {

	@Autowired
	MarketService marketService;
	
    @Autowired
    public JmsTemplate jmsTemplate;

    @Autowired
    public Queue queueCardShop;
    
    @Autowired
    public Queue queueCardCollection;
	
	@Override
	public ResponseEntity<HttpStatus> sellCard(MarketDTO market) {
		if (marketService.sellCard(market)) {
			jmsTemplate.convertAndSend(queueCardCollection, market.getId());
			jmsTemplate.convertAndSend(queueCardShop, market.getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	}

	@Override
	public ResponseEntity<HttpStatus> buyCard(MarketDTO market) {
		if (marketService.buyCard(market)) {
			jmsTemplate.convertAndSend(queueCardCollection, market.getId());
			jmsTemplate.convertAndSend(queueCardShop, market.getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
