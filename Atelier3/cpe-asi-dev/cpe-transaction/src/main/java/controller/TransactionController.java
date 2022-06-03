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
import rest.TransactionRest;
import service.TransactionService;
import pojo.transaction.Transaction;

@CrossOrigin
@RestController
public class TransactionController implements TransactionRest {

	@Autowired
	TransactionService transactionService;

	@Override
	public ResponseEntity<List<Transaction>> getTransactionsByUser(int userId) {
		if (transactionService.getTransactionsByUser(userId) != null) {
			return (ResponseEntity<List<Transaction>>) transactionService.getTransactionsByUser(userId);
		} else {
			return null;
		}	
	}
	
	
	  @Override public ResponseEntity<HttpStatus> addTransaction(int userId, int cardId,  Double cardPrice, String transacDate) { if
	  (transactionService.addTransaction(userId, cardId, cardPrice, transacDate)) { return new
	  ResponseEntity<>(HttpStatus.OK); } else { return new
	  ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 
}