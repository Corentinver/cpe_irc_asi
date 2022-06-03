package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import dto.MarketDTO;
import pojo.user.User;
import repository.TransactionRepository;
import pojo.card.Card;
import pojo.transaction.Transaction;
import rest.UserRest;
import rest.CardRest;

@Service
public class TransactionService {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private TransactionRepository transactionRepository = new TransactionRepository();

	public List<Transaction> getTransactionsByUser(int userId) {

		Optional<List<Transaction>> transactions = transactionRepository.getTransactionsByUser(userId);
    	
    	if(transactions.isPresent()) {
    		return transactions.get();
    	}
    	return null;
	}

	public boolean addTransaction(int userId, int cardId, Double cardPrice, String transacDate) {
		transactionRepository.AddTransaction(userId, cardId, cardPrice, transacDate);
	}
}