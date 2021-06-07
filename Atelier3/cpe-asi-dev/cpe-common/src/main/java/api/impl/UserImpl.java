package api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import dto.UserDTO;
import dto.UserRegister;
import rest.UserRest;

public class UserImpl implements UserRest {

	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<Double> addMoney(Integer id, double amount) {
		return this.restTemplate.getForEntity("", Double.class);
	}

	public ResponseEntity<Double> removeMoney(Integer id, double amount) {
		return this.restTemplate.getForEntity("", Double.class);
	}

	public ResponseEntity<HttpStatus> addCard(Integer id, Integer cardId) {
		return this.restTemplate.getForEntity("", HttpStatus.class);
	}

	public ResponseEntity<HttpStatus> removeCard(Integer id, Integer cardId) {
		return this.restTemplate.getForEntity("", HttpStatus.class);
	}

	public ResponseEntity<Integer> getUserById(Integer id) {
		return this.restTemplate.getForEntity("", Integer.class);
	}

	public ResponseEntity<UserDTO> createUser(UserRegister userRegister) {
		return this.restTemplate.getForEntity("", UserDTO.class);
	}

}
