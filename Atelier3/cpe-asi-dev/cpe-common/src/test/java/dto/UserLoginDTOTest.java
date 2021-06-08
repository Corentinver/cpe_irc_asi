package dto;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserLoginDTOTest {

	@Test
	public void createUserLoginDTO() {
		UserLoginDTO userLoginDTO = new UserLoginDTO("test-surname", "test-pwd");
		
		assertTrue(userLoginDTO.getSurname() == "test-surname");
		assertTrue(userLoginDTO.getPassword() == "test-pwd");
		
		userLoginDTO.setSurname("test-surnameBis");
		userLoginDTO.setPassword("test-pwdBis");
		
		assertTrue(userLoginDTO.getSurname() == "test-surnameBis");
		assertTrue(userLoginDTO.getPassword() == "test-pwdBis");
	}
}
