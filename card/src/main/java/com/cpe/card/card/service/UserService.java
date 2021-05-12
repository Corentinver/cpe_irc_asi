package com.cpe.card.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.card.card.dto.UserRegister;
import com.cpe.card.card.pojo.User;
import com.cpe.card.card.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
    
    public User createUser(User userInfo) {
    	User user = new User(null, userInfo.getPassword(), userInfo.getSurname(), userInfo.getName(), 0, null);
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