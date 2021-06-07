package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UserDTO;
import dto.UserRegister;
import pojo.User;
import rest.UserRest;
import service.UserService;

@CrossOrigin
@RestController
public class UserController implements UserRest {

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<Double> addMoney(Integer userId, double amount) {
		return new ResponseEntity<Double>(userService.addMoney(userId, amount), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Double> removeMoney(Integer userId, double amount) {
		return new ResponseEntity<Double>(userService.removeMoney(userId, amount), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HttpStatus> addCard(Integer userId, Integer cardId) {
		return null;
	}

	@Override
	public ResponseEntity<HttpStatus> removeCard(Integer userId, Integer cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<User> getUserById(Integer userId) {
		User user = userService.findById(userId);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<UserDTO> createUser(UserRegister userRegister) {
		// TODO Auto-generated method stub
		return null;
	}



}