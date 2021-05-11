package com.cpe.card.card.dto;

public class UserRegister {

	private String surname;
	private String password;
	
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
