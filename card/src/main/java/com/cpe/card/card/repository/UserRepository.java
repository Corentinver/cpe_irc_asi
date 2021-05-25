package com.cpe.card.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpe.card.card.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
    @Query(" select u from User u " +
            " where u.surname = ?1")
    Optional<User> findUserWithName(String username);
    
    @Query(" select u from User u " +
    		" where u.surname = ?1 and u.password = ?2")
	Optional<User> findUserWithSurnameAndPassword(String surname, String password);
    
    @Query(" select u from User u " +
            " where u.id = :id and u.money > :money")
    int hasEnoughMoney(@Param("id") int id, @Param("money") double money);
    
    @Modifying
    @Query("update User u " +
    	   "Set u.money = (u.money-:money)" + 
            " where u.id = :id")
    int pickUpMoney(@Param("id") int id, @Param("money") double money);
    
    @Modifying
    @Query("update User u " +
     	   "Set u.money = (u.money+:money)" + 
             " where u.id = :id")
    int addMoney(@Param("id") int id, @Param("money") double money);
}