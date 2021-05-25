package com.cpe.card.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.card.card.dto.UserRegister;
import com.cpe.card.card.service.UserService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserRegister user) {
		System.out.println(user.getSurname() + " " + user.getPassword());
		//UserRegister userRegister = new UserRegister(surname, password);
		return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
