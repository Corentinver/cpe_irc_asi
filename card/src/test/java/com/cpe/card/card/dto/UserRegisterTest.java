package com.cpe.card.card.dto;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class UserRegisterTest {

	@Test
	public void createUserRegister() {
		UserRegister user = new UserRegister("test", "pwd");

		assertTrue(user.getSurname() == "test");
		assertTrue(user.getPassword() == "pwd");

		user.setSurname("testBis");
		user.setPassword("pwdBis");

		assertTrue(user.getSurname() == "testBis");
		assertTrue(user.getPassword() == "pwdBis");
	}
	
}
