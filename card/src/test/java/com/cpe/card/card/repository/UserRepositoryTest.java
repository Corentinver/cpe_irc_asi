package com.cpe.card.card.repository;

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
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    CardRepository cardRepository;
	
    @Before
    public void setUp() {
    	// TODO (add Users with Cards)
    }

    @After
    public void cleanUp() {
        userRepository.deleteAll();
    }
    
    @Test
    public void findUserWithName() throws Exception {
    	// TODO
    }
    
    @Test
    public void findUserWithSurnameAndPassword() throws Exception {
    	// TODO
    }
    
    @Test
    public void hasEnoughMoney() throws Exception {
    	// TODO
    }
    
    @Test
    public void pickUpMoney() throws Exception {
    	// TODO
    }
    
    @Test
    public void addMoney() throws Exception {
    	// TODO
    }
    
    @Test
    public void createUser() throws Exception {
    	// TODO
    }
    
}
