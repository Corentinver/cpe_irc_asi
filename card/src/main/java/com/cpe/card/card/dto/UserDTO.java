package com.cpe.card.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import lombok.Data;

@Data
public class UserDTO {
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("password")
	@JsonSerialize(using = StringSerializer.class)
	private String password;
}
