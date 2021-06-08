package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dto.UserGetDTO;
import dto.UserLoginDTO;
import pojo.User;
import rest.LoginRest;
import service.UserService;
import utils.MapStructMapperImpl;

public class LoginController implements LoginRest{

	@Autowired
	private UserService userService;
	
	@Autowired
	private MapStructMapperImpl mapper;
	
	@Override
	public ResponseEntity<UserGetDTO> login(UserLoginDTO userLogin) {
		User user = userService.login(userLogin);
		if (user != null) {
			return new ResponseEntity<UserGetDTO>(mapper.userToUserGetDTO(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> logout() {
		return null;
	}

}
