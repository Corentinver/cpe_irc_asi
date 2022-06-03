package service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.UserGetDTO;
import dto.UserLoginDTO;
import pojo.card.Card;
import pojo.user.User;
import repository.UserRepository;
import rest.CardRest;
import rest.UserRest;
import utils.MapStructMapperImpl;

import java.util.Optional;

/**
 * 
 * @author Gouy Quentin
 * Class Service User utilisant la class jpa pour récupérer et ajouter un utilisateur.
 */
@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
    
    public User createUser(User userInfo) {
    	String url = CardRest.SERVER + CardRest.BASE_URL;
		
    	List<Card> allCards = Arrays.asList(restTemplate.getForObject(url, Card[].class));
    	List<Card> randomCards = new ArrayList<Card>();
    	/*for(int i = 0; i < 5; i++) {
    		int randomInt = ThreadLocalRandom.current().nextInt(0, allCards.size());
    		userInfo.addCard(allCards.get(randomInt).getId());
    	}*/
    	
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
		if(amount <= 0) {
			return null;
		}
		
		User user = this.findById(userId);
		
		user.setMoney(user.getMoney() + amount);
		userRepository.save(user);
		
		return user.getMoney();
	}

	public Double removeMoney(Integer userId, double amount) {
		if(amount <= 0) {
			return null;
		}
		
		User user = this.findById(userId);
		
		user.setMoney(user.getMoney() - amount);
		userRepository.save(user);
		
		return user.getMoney();
	}
	
	public boolean addCard(Integer userId, Integer cardId) {
		if(cardId <= 0) {
			return false;
		}
		
		User user = this.findById(userId);
		
		// Si l'utilisateur possède déjà la carte.
		if(user.containsCardId(cardId)) {
			return false;
		}
		
		user.addCard(cardId);
		
		return userRepository.save(user).containsCardId(cardId);
	}
	
	
	public boolean removeCard(Integer userId, Integer cardId) {
		if(cardId <= 0) {
			return false;
		}
		
		User user = this.findById(userId);
		
		// Si l'utilisateur ne possède pas la carte.
		if(!user.containsCardId(cardId)) {
			return false;
		}
		
		user.removeCard(cardId);
		
		return !userRepository.save(user).containsCardId(cardId);
	}
	
}