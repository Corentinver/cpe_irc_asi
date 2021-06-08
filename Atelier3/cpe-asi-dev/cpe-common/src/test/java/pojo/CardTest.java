package pojo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardTest {

	@Test
	public void createCard() {
		Card card = new Card(
				1, "test-Name", "test-Description", 150, 100, 15.5, "test-Path",
				new Family(1, "test-Name"), new Affinity(1, "test-Name"));
		
		assertTrue(card.getId() == 1);
		assertTrue(card.getName() == "test-Name");
		assertTrue(card.getDescription() == "test-Description");
		assertTrue(card.getEnergy() == 150);
		assertTrue(card.getHp() == 100);
		assertTrue(card.getPrice() == 15.5);
		assertTrue(card.getPath() == "test-Path");

		card.setId(5);
		card.setName("test-NameBis");
		card.setDescription("test-DescriptionBis");
		card.setEnergy(115);
		card.setHp(65);
		card.setPrice(10.5);
		card.setPath("test-PathBis");
		
		assertTrue(card.getId() == 5);
		assertTrue(card.getName() == "test-NameBis");
		assertTrue(card.getDescription() == "test-DescriptionBis");
		assertTrue(card.getEnergy() == 115);
		assertTrue(card.getHp() == 65);
		assertTrue(card.getPrice() == 10.5);
		assertTrue(card.getPath() == "test-PathBis");
	}
}