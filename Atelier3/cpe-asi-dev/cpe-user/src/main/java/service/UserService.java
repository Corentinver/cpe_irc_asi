package service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import dto.UserDTO;
import dto.UserRegister;
import pojo.Card;
import pojo.User;
import repository.UserRepository;

import java.util.Optional;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private CardRepository cardRepository;
    
    public User createUser(User userInfo) {
    	/*
    	List<Card> allCards = cardRepository.findAll();
    	List<Card> randomCards = new ArrayList<Card>();

    	for(int i = 0; i < 5; i++) {
    		int randomInt = ThreadLocalRandom.current().nextInt(0, allCards.size());
    		randomCards.add(allCards.get(randomInt));
    		allCards.remove(randomInt);
    	}
    	
    	
    	
    	User user = new User(null, userInfo.getPassword(), userInfo.getSurname(), userInfo.getName(), 5000, randomCards);
    	return userRepository.save(user);*/
    	return null;
    }
    
    public Boolean canBuy(int userId, double money) {
    	/*
    	Boolean result = false;
    	
    	Optional<User> user = userRepository.findById(userId);
    	if(user.isPresent() && user.get().getMoney() >= money) {
    		result = true;
    	}
    	
    	return result;
    	//return userRepository.hasEnoughMoney(userId, money) != 0;*/
    	return null;
    }
    
    public void buy(int userId, Card card) {
    	/*
    	Optional<User> user = userRepository.findById(userId);
    	if(user.isPresent()) {
    		user.get().setMoney(user.get().getMoney() - card.getPrice());
    		user.get().addCard(card);
    		userRepository.save(user.get());
    	}
    	
    	//return user.get();
    	//userRepository.pickUpMoney(userId, money);
    	 *
    	 */
    }
    
    public void sell(int userId, Card card) {
    	/*
    	Optional<User> user = userRepository.findById(userId);
    	if(user.isPresent()) {
    		user.get().setMoney(user.get().getMoney() + card.getPrice());
    		user.get().removeCard(card);
    		userRepository.save(user.get());
    	}
    	//userRepository.addMoney(userId, money);
    	 * 
    	 */
    }
    
    public User findById(int userId) {
    	/*
    	Optional<User> user = userRepository.findById(userId);
    	
    	if(user.isPresent()) {
    		return user.get();
    	}
    	*/
    	return null;
    }
    
    public UserDTO login(UserRegister userRegister) {
    	/*
    	Optional<User> user = userRepository.findUserWithSurnameAndPassword(userRegister.getSurname(), userRegister.getPassword());
    	UserDTO userDTO = null;
    	if(user.isPresent()) {
    		userDTO = new UserDTO(user.get().getUserId(), user.get().getSurname(), user.get().getPassword(), user.get().getMoney());
    	}
    	
    	return userDTO;
    	*/
    	return null;
    }

	public Double addMoney(Integer userId, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double removeMoney(Integer userId, double amount) {
		// TODO Auto-generated method stub
		return null;
	}
}