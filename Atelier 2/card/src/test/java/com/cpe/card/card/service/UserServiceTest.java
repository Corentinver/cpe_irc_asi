package com.cpe.card.card.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.card.card.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserService.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void createUser() {
		// TODO
	}
	
	@Test
	public void canBuy() {
		// TODO
	}
	
	@Test
	public void buy() {
		// TODO
	}
	
	@Test
	public void sell() {
		// TODO
	}
	
	@Test
	public void findById() {
		// TODO
	}
	
	@Test
	public void login() {
		// TODO
	}
	
}
