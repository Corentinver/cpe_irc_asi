package com.cpe.card.card.pojo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AffinityTest {

	@Test
	public void createAffinity() {
		Affinity affinity = new Affinity(1, "test-Name");
		
		assertTrue(affinity.getId() == 1);
		assertTrue(affinity.getName() == "test-Name");
		
		affinity.setId(5);
		affinity.setName("test-NameBis");
		
		assertTrue(affinity.getId() == 5);
		assertTrue(affinity.getName() == "test-NameBis");
	}
}
