package com.cpe.card.card.dto;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class UserDTOTest {

	@Test
	public void createUserDTO() {
		UserDTO user = new UserDTO(1, "test", "pwd", 50);
		
		assertTrue(user.getId() == 1);
		assertTrue(user.getSurname() == "test");
		assertTrue(user.getPassword() == "pwd");
		assertTrue(user.getMoney() == 50);
		
		user.setId(5);
		user.setSurname("testBis");
		user.setPassword("pwdBis");
		user.setMoney(15);
		
		assertTrue(user.getId() == 5);
		assertTrue(user.getSurname() == "testBis");
		assertTrue(user.getPassword() == "pwdBis");
		assertTrue(user.getMoney() == 15);
	}
}
