package com.cpe.card.card.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cpe.card.card.dto.User;
import com.cpe.card.card.dto.UserRegister;
import com.cpe.card.card.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        User user = userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
    
    public User createUser(UserRegister userInfo) {
    	return userRepository.createUser(new User(1, "", userInfo.getPassword(), userInfo.getSurname(), userInfo.getName(), 10.0));
    }
    
    public Boolean canBuy(int userId, double money) {
    	return userRepository.hasEnoughMoney(userId, money).isPresent();
    }
}