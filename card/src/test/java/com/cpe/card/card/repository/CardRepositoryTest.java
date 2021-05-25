package com.cpe.card.card.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.card.card.pojo.Affinity;
import com.cpe.card.card.pojo.Card;
import com.cpe.card.card.pojo.Family;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
public class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository;
	
    @BeforeAll
    public void setUp() { 
    	for(int i = 1; i < 11; i++) {
    		Card card = new Card(i, "test-Name" + i, "test-Description" + i, 10 * i, 25 * i, 5.5 * i,
    				"test-Path" + i, new Family(i, "test-Name" + i), new Affinity(i, "test-Name" + i));
    		cardRepository.save(card);
    	}
    }

    @AfterAll
    public void cleanUp() {
        cardRepository.deleteAll();
    }
    
    @Test
    public void findAll() throws Exception {
    	List<Card> allCards = cardRepository.findAll();
    	assertTrue(allCards.size() == 10);
    }
    
    @Test
    public void findById() throws Exception {
    	int i = 5;

    	Card card = cardRepository.findById(i).get();

    	assertTrue(card.getId() == i);
    	assertTrue(card.getName().equals("test-Name" + i));
    	assertTrue(card.getDescription().equals("test-Description" + i));
    	assertTrue(card.getEnergy() == i * 10);
    	assertTrue(card.getHp() == i * 25);
    	assertTrue(card.getPrice() == i * 5.5);
    	assertTrue(card.getPath().equals("test-Path" + i));
    }
    
}
