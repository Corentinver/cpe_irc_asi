package com.cpe.card.card.repository;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpe.card.card.pojo.Card;
import com.cpe.card.card.pojo.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
	
    @BeforeAll
    public void setUp() {
		User user = new User(1, "test-pwd", "test-surname", "test-name", 25.5, new ArrayList<Card>());
		userRepository.save(user);
    }

    @AfterAll
    public void cleanUp() {
        userRepository.deleteAll();
    }
    
    @Test
    public void findUserWithName() throws Exception {
    	String surname = "test-surname";

    	User user = userRepository.findUserWithName(surname).get();
    	
    	assertTrue(user.getSurname().equals(surname));
    }
    
    @Test
    public void findUserWithSurnameAndPassword() throws Exception {
    	String surname = "test-surname";
    	String password = "test-pwd";
    	
    	User user = userRepository.findUserWithSurnameAndPassword(surname, password).get();
    	
    	assertTrue(user.getSurname().equals(surname));
    	assertTrue(user.getPassword().equals(password));
    }
    
}
