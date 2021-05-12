package com.cpe.card.card.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.card.card.repository.CardRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MarketService.class)
public class MarketServiceTest {

	@Autowired
	private MarketService marketService;

	@MockBean
	private CardRepository cardRepository;
	
	@Test
	public void buyCard() {
		// TODO
	}
	
	@Test
	public void sellCard() {
		// TODO
	}
	
}
