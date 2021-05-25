package com.cpe.card.card.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.card.card.pojo.Card;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository;
	
    @Before
    public void setUp() {
    	/*for(int i = 0; i < 10; i++) {
            cardRepository.save(new Card(i, 
            		"Card" + i + "Test - Name", 
            		"Card" + i + "Test - Description",
            		10 * i, 10* i , 50 * i, 
            		"Card" + i + "Test - Path"));
    	}*/
    }

    @After
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
    	assertTrue(card.getName() == "Card" + i + "Test - Name");
    	assertTrue(card.getDescription() == "Card" + i + "Test - Description");
    	assertTrue(card.getEnergy() == i * 10);
    	assertTrue(card.getHp() == i * 10);
    	assertTrue(card.getPrice() == i * 50);
    	assertTrue(card.getPath() == "Card" + i + "Test - Path");
    }
    
}
