package com.cpe.card.card.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cpe.card.card.service.CardService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardController.class)
public class CardControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CardService cardService;
	
	@Test
	public void getOwnedCardsByUser() throws Exception {
		// TODO
	}
	
	@Test
	public void getUnownedCards() throws Exception {
		// TODO
	}
	
}
