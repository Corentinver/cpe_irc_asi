package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pojo.transaction.Transaction;
import pojo.user.User;

/**
 * 
 * @author Poulard Antonin
 * Interface de liaison entre la base de données et notre service
 * Interface Data access
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	/**
	 * Recherche d'un des transactions d'un utilisateur
	 * @param userId
	 * @return Transactions
	 */
    @Query(" select * from Transactions " +
            " where userId = ?1")
    Optional<List<Transaction>>  getTransactionsByUser(int userId);
    
	/**
	 * Ajout d'une transaction
	 * @param surname, password
	 * @return User
	 */
    @Query("Insert into public.transaction(userId, cardId, cardPrice, transacDate)" +
    		" values (?1,?2,?3,?4")
	Optional<Transaction> AddTransaction( int userId, int cardId,  Double cardPrice, String transacDate);

}