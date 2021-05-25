package com.cpe.card.card.pojo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
	public void createUser() {
		
		List<Card> cards = new ArrayList<>();
		
		for(int i = 1; i < 5; i++) {
			cards.add(
					new Card(
						i, "test-Name" + i, "test-Description" + i, 10 * i, 25 * i, 5.5 * i, "test-Path" + i,
						new Family(i, "test-Name" + i), new Affinity(i, "test-Name" + i)));
		}
		
		User user = new User(1, "test-pwd", "test-surname", "test-name", 25.5, cards);
		
		assertTrue(user.getUserId() == 1);
		assertTrue(user.getPassword() == "test-pwd");
		assertTrue(user.getSurname() == "test-surname");
		assertTrue(user.getMoney() == 25.5);
		assertTrue(user.getCards().size() == cards.size());
		
		user.addCard(cards.get(0));

		assertTrue(user.getCards().size() == cards.size());

		user.removeCard(cards.get(1));

		assertTrue(user.getCards().size() == cards.size());
		
		user.setUserId(5);
		user.setPassword("test-pwdBis");
		user.setSurname("test-surnameBis");
		user.setMoney(55.5);
		
		assertTrue(user.getUserId() == 5);
		assertTrue(user.getPassword() == "test-pwdBis");
		assertTrue(user.getSurname() == "test-surnameBis");
		assertTrue(user.getMoney() == 55.5);
	}

}
