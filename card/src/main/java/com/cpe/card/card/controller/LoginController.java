package com.cpe.card.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.card.card.dto.UserRegister;
import com.cpe.card.card.service.UserService;

@RestController
public class LoginController {

	@Autowired UserService userService;

	@RequestMapping(method=RequestMethod.POST,value="/login")
	public ResponseEntity<?> login(@RequestParam String surname, @RequestParam String password) {
		UserRegister userRegister = new UserRegister(surname, password);
		return new ResponseEntity<>(userService.login(userRegister), HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
