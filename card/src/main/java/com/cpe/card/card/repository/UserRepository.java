package com.cpe.card.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cpe.card.card.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
    @Query(" select u from User u " +
            " where u.surname = ?1")
    Optional<User> findUserWithName(String username);
    
    @Query(" select u from User u " +
    		" where u.surname = ?1 and u.password = ?2")
	Optional<User> findUserWithSurnameAndPassword(String surname, String password);
    
    @Query(" select u from User u " +
            " where u.surname = ?1 and u.money > ?2")
    Optional<User> hasEnoughMoney(int id, double money);
    
    @Query(" update User u " +
    	   "Set u.money = u.money - ?2" + 
            " where u.surname = ?1")
    Optional<User> pickUpMoney(int id, double money);
    
    @Query(" update User u " +
     	   "Set u.money = u.money + ?2" + 
             " where u.surname = ?1")
    Optional<User> addMoney(int id, double money);
}