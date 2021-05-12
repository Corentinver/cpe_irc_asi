package com.cpe.card.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.cpe.card.card.dto.UserRegister;
import com.cpe.card.card.pojo.Card;
import com.cpe.card.card.pojo.User;
import com.cpe.card.card.repository.CardRepository;
import com.cpe.card.card.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CardRepository cardRepository;
    
    public User createUser(User userInfo) {
    	List<Card> allCards = cardRepository.findAll();
    	List<Card> randomCards = new ArrayList<Card>();

    	for(int i = 0; i < 5; i++) {
    		int randomInt = ThreadLocalRandom.current().nextInt(0, allCards.size());
    		randomCards.add(allCards.get(randomInt));
    	}
    	
    	User user = new User(null, userInfo.getPassword(), userInfo.getSurname(), userInfo.getName(), 5000, randomCards);
    	return userRepository.save(user);
    }
    
    public Boolean canBuy(int userId, double money) {
    	return userRepository.hasEnoughMoney(userId, money).isPresent();
    }
    
    public void buy(int userId, double money) {
    	userRepository.pickUpMoney(userId, money);
    }
    
    public void sell(int userId, double money) {
    	userRepository.addMoney(userId, money);
    }
    
    public User findById(int userId) {
    	java.util.Optional<User> user = userRepository.findById(userId);
    	
    	if(user.isPresent()) {
    		return user.get();
    	}
    	
    	return null;
    }
    
    public User login(UserRegister userRegister) {
    	java.util.Optional<User> user = userRepository.findUserWithSurnameAndPassword(userRegister.getSurname(), userRegister.getPassword());
    	
    	if(user.isPresent()) {
    		return user.get();
    	}
    	
    	return null;
    }
}