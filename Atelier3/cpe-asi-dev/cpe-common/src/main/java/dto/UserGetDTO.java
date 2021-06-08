package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserGetDTO {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("money")
	private double money;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public UserGetDTO() {
		
	}

	public UserGetDTO(int id, String surname, String password, double money) {
		super();
		this.id = id;
		this.surname = surname;
		this.money = money;
	}
	

}
