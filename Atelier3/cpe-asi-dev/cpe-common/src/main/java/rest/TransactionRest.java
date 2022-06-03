package rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.transaction.Transaction;


@RequestMapping(value = TransactionRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface TransactionRest {


    public static final String BASE_URL = "/transactions";
    public static final String GET_TRANSAC_URL = "/getTransactionsUser";
    public static final String ADD_TRANSAC_URL = "/addTransactions";
    
	/**
	 * Récupération des transactions pour un User
	 * @param market
	 * @return liste Transactions
	 */
    @RequestMapping(
    		value = GET_TRANSAC_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Transaction>> getTransactionsByUser(@RequestBody int userId);
    
	/**
	 * Ajout d'une transaction
	 * @param market
	 * @return Ok ou non 
	 */
    @RequestMapping(
    		value = ADD_TRANSAC_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> addTransaction(@RequestBody int userId, int cardId,  Double cardPrice, String transacDate);
    
}

