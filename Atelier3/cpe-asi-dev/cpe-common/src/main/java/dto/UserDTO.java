package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;


public class UserDTO {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty(access = Access.WRITE_ONLY, value="password")
	private String password;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public UserDTO(int id, String surname, String password, double money) {
		super();
		this.id = id;
		this.surname = surname;
		this.password = password;
		this.money = money;
	}
	
	public UserDTO() {
		
	}
	
	
	
	
}
