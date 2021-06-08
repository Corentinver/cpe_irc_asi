package service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import dto.UserGetDTO;
import dto.UserLoginDTO;
import pojo.Card;
import pojo.User;
import repository.UserRepository;
import utils.MapStructMapperImpl;

import java.util.Optional;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
    
    public User createUser(User userInfo) {
    	/*
    	List<Card> allCards = cardRepository.findAll();
    	List<Card> randomCards = new ArrayList<Card>();

    	for(int i = 0; i < 5; i++) {
    		int randomInt = ThreadLocalRandom.current().nextInt(0, allCards.size());
    		randomCards.add(allCards.get(randomInt));
    		allCards.remove(randomInt);
    	}
    	
    	
    	
    	User user = new User(null, userInfo.getPassword(), userInfo.getSurname(), userInfo.getName(), 5000, randomCards);*/
    	return userRepository.save(userInfo);
    }
    
    
    public User findById(int userId) {
    	Optional<User> user = userRepository.findById(userId);
    	
    	if(user.isPresent()) {
    		return user.get();
    	}
    	
    	return null;
    }
    
    
    public User login(UserLoginDTO userLogin) {
    	Optional<User> user = userRepository.findUserWithSurnameAndPassword(userLogin.getSurname(), userLogin.getPassword());
    	if(user.isPresent()) {
    		return user.get();
    	}
    	
    	return null;
    }

	public Double addMoney(Integer userId, double amount) {	
		User user = this.findById(userId);
		
		user.setMoney(user.getMoney() + amount);
		userRepository.save(user);
		
		return user.getMoney();
	}

	public Double removeMoney(Integer userId, double amount) {
		User user = this.findById(userId);
		
		user.setMoney(user.getMoney() - amount);
		userRepository.save(user);
		
		return user.getMoney();
	}
	
	public boolean addCard(Integer userId, Integer cardId) {
		User user = this.findById(userId);
		user.addCard(cardId);
		
		return !userRepository.save(user).containsCardId(cardId);
	}
	
	
	public boolean removeCard(Integer userId, Integer cardId) {
		User user = this.findById(userId);
		user.removeCard(cardId);
		
		return !userRepository.save(user).containsCardId(cardId);
	}
	
}