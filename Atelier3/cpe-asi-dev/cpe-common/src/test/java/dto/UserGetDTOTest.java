/*package dto;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserGetDTOTest {

	@Test
	public void createUserGetDTO() {
		UserGetDTO userGetDTO = new UserGetDTO(1, "test-surname", "test-pwd", 25.5);
		
		assertTrue(userGetDTO.getId() == 1);
		assertTrue(userGetDTO.getSurname() == "test-surname");
		assertTrue(userGetDTO.getMoney() == 25.5);
		
		userGetDTO.setId(5);
		userGetDTO.setSurname("test-surnameBis");
		userGetDTO.setMoney(55.5);
		
		assertTrue(userGetDTO.getId() == 5);
		assertTrue(userGetDTO.getSurname() == "test-surnameBis");
		assertTrue(userGetDTO.getMoney() == 55.5);
	}
}
*/