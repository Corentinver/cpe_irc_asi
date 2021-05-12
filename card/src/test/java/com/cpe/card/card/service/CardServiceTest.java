package com.cpe.card.card.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.card.card.repository.CardRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardService.class)
public class CardServiceTest {
	
	@Autowired
	private CardService cardService;

	@MockBean
	private CardRepository cardRepository;
	
	@Test
	public void getCollectionCardsByUser() {
		// TODO
	}
	
	@Test
	public void getShopCardsByUser() {
		// TODO
	}
	
	@Test
	public void getCardById() {
		// TODO
	}
}
