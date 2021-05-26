package com.cpe.card.card.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.card.card.pojo.Affinity;
import com.cpe.card.card.pojo.Card;
import com.cpe.card.card.pojo.Family;
import com.cpe.card.card.pojo.User;
import com.cpe.card.card.repository.CardRepository;
import com.cpe.card.card.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardService.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CardServiceTest {
	
	@Autowired
	private CardService cardService;

	@MockBean
	private CardRepository cardRepository;
	
	@MockBean
	private UserRepository userRepository;
	
	private List<Card> allCards = new ArrayList<Card>();
	private List<Card> userCards = new ArrayList<Card>();
	private User user;
	
	private Card card = new Card(1, "test-Name", "test-Description", 10, 25, 5.5, "test-Path",
			new Family(1, "test-Name"), new Affinity(1, "test-Name"));
	
	@BeforeAll
	public void setUp() {
		for(int i = 1; i < 21; i++) {
			this.allCards.add(
					new Card(
						i, "test-Name" + i, "test-Description" + i, 10 * i, 25 * i, 5.5 * i, "test-Path" + i,
						new Family(i, "test-Name" + i), new Affinity(i, "test-Name" + i)));
		}
		
		// Get the first five elements of allCards.
		this.userCards = this.allCards.stream().limit(5).collect(Collectors.toList());
		
		this.user = new User(1, "test-pwd", "test-surname", "test-name", 25.5, this.userCards);
	}
	
	@Test
	public void getCollectionCardsByUser() {
		Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(this.user));

		List<Card> cards = cardService.getCollectionCardsByUser(this.user.getUserId());

		assertTrue(cards == this.userCards);
	}
	
	@Test
	public void getShopCardsByUser() {
		Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(this.user));
		Mockito.when(cardRepository.findAll()).thenReturn(this.allCards);
		
		List<Card> buyableCards = cardService.getShopCardsByUser(this.user.getUserId());
		
		List<Card> testBuyableCards = this.allCards;
		testBuyableCards.removeAll(this.userCards);
		
		assertTrue(buyableCards == testBuyableCards);
	}
	
	@Test
	public void getCardById() {
		Mockito.when(cardRepository.findById(0)).thenReturn(Optional.ofNullable(this.allCards.get(0)));

		
		assertTrue(cardService.getCardById(0) == this.allCards.get(0));
	}
}
