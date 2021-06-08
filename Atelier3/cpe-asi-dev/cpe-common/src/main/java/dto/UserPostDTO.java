package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPostDTO {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("password")
	private String password;
	
	public UserPostDTO() {
		
	}
	
	public UserPostDTO(String name, String surname, String password) {
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
