package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UserGetDTO;
import dto.UserPostDTO;
import pojo.user.User;
import rest.UserRest;
import service.UserService;
import utils.MapStructMapperImpl;

@CrossOrigin
@RestController
public class UserController implements UserRest {

	@Autowired
	private UserService userService;
	
	private MapStructMapperImpl mapper = new MapStructMapperImpl();

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
		boolean result = userService.addCard(userId, cardId);
		if(result) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> removeCard(Integer userId, Integer cardId) {
		boolean result = userService.removeCard(userId, cardId);
		if(result) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
	public ResponseEntity<UserGetDTO> createUser(UserPostDTO userPostDTO) {
		User user = mapper.userPostDTOtoUser(userPostDTO);
		User userCreated = userService.createUser(user);
		if (userCreated != null) {
			return new ResponseEntity<UserGetDTO>(mapper.userToUserGetDTO(userCreated), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}