package pojo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pojo.card.Family;

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