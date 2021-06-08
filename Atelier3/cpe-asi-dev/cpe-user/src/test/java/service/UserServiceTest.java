package service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pojo.User;
import repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserService.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	private User user;
	
	@BeforeAll
	public void setUp() {
		this.user = new User();
		user.setUserId(1);
		user.setName("test-name");
		user.setSurname("test-surname");
		user.setMoney(50);
		user.setCards(new Integer[]{1, 2, 3});
	}

	@Test
	public void findById() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		
		assertTrue(userService.findById(1).getName() == this.user.getName());
	}
	
	@Test
	public void addMoney_Positive() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(null);
		
		assertTrue(userService.addMoney(this.user.getUserId(), 50) == 100);
	}
	
	@Test
	public void addMoney_Negative() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(null);
		
		assertTrue(userService.addMoney(this.user.getUserId(), -50) == 50); // L'argent n'a pas changé.
	}
	
	@Test
	public void removeMoney_Positive() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(null);
		
		assertTrue(userService.removeMoney(this.user.getUserId(), 50) == 0);
	}
	
	@Test
	public void removeMoney_Negative() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(null);
		
		assertTrue(userService.removeMoney(this.user.getUserId(), -50) == 50); // L'argent n'a pas changé.
	}
	
	@Test
	public void addCard_HasAlreadyCard() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(this.user);
		
		assertTrue(userService.addCard(this.user.getUserId(), 1) == true);
	}
	
	@Test
	public void addCard_CardAdded() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(this.user);
		
		assertTrue(userService.addCard(this.user.getUserId(), 5) == true);
	}
	
	@Test
	public void addCard_CardNotAdded() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(this.user);
		
		assertTrue(userService.addCard(this.user.getUserId(), -5) == false);
	}
	
	@Test
	public void removeCard_NotHasCard() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(this.user);
		
		assertTrue(userService.removeCard(this.user.getUserId(), 5) == true);
	}
	
	@Test
	public void removeCard_CardRemoved() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(this.user);
		
		assertTrue(userService.removeCard(this.user.getUserId(), 2) == true);
	}
	
	@Test
	public void removeCard_CardNotRemoved() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(this.user);
		
		assertTrue(userService.removeCard(this.user.getUserId(), -5) == true);
	}
}
