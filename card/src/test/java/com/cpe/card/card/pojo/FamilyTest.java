package com.cpe.card.card.pojo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class FamilyTest {
	
	@Test
	public void createFamily() {
		Family family = new Family(1, "test-Name");
		
		assertTrue(family.getId() == 1);
		assertTrue(family.getName() == "test-Name");
		
		family.setId(5);
		family.setName("test-NameBis");
		
		assertTrue(family.getId() == 5);
		assertTrue(family.getName() == "test-NameBis");
	}

}
