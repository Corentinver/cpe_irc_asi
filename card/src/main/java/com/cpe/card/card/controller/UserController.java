package com.cpe.card.card.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.card.card.dto.UserRegister;
import com.cpe.card.card.pojo.User;
import com.cpe.card.card.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<?> createUser(@RequestBody UserRegister userInfos) {
		return new ResponseEntity<>(userService.createUser(userInfos), HttpStatus.OK);
		/*catch(IOException e) {
			return new ResponseEntity
		}*/
		
	}
	
}
