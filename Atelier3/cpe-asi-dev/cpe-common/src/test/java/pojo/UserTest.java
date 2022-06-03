/*package pojo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pojo.user.User;

public class UserTest {
	
	@Test
	public void createUser() {

		Integer[] cards = new Integer[] {1, 2, 3};
		
		User user = new User();
		user.setUserId(1);
		user.setName("test-name");
		user.setSurname("test-surname");
		user.setPassword("test-pwd");
		user.setMoney(50);
		user.setCards(cards);
		
		assertTrue(user.getUserId() == 1);
		assertTrue(user.getName() == "test-name");
		assertTrue(user.getSurname() == "test-surname");
		assertTrue(user.getPassword() == "test-pwd");
		assertTrue(user.getMoney() == 50);
		assertTrue(user.getCards().length == cards.length);
		
		user.addCard(4); // On ajoute la carte 4.

		assertTrue(user.getCards().length == cards.length + 1);

		user.removeCard(1); // On supprime la carte 1.

		assertTrue(user.getCards().length == cards.length);
		
		user.setUserId(5);
		user.setPassword("test-pwdBis");
		user.setSurname("test-surnameBis");
		user.setMoney(55.5);
		
		assertTrue(user.getUserId() == 5);
		assertTrue(user.getPassword() == "test-pwdBis");
		assertTrue(user.getSurname() == "test-surnameBis");
		assertTrue(user.getMoney() == 55.5);
	}

}*/