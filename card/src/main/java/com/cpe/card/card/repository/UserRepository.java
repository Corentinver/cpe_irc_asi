package com.cpe.card.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cpe.card.card.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
    @Query(" select u from User u " +
            " where u.username = ?1")
    Optional<User> findUserWithName(String username);
    
    @Query(" select u from User u " +
            " where u.username = ?1 and money > ?2")
    Optional<User> hasEnoughMoney(int id, double money);
    
    @Query(" update User " +
    	   "Set money -= ?2" + 
            " where u.username = ?1")
    Optional<User> pickUpMoney(int id, double money);
    
    User createUser(User user);
    
}