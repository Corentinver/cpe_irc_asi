package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegister {

	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("password")
	private String password;
	
	public UserRegister() {
	}
	
	public UserRegister(String surname, String password) {
		setSurname(surname);
		setPassword(password);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
