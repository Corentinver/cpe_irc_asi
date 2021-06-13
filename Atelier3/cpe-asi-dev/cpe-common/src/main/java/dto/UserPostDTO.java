package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Myniz
 * Class DTO UserPost pour l'enregistrement d'un compte utilisateur à notre système.
 * Utiliser dans le transfer de la donnée du côté client vers le côté serveur API.
 * Nous avons différencié les DTO de la création d'un utilisateur à sa connexion 
 * Car ce n'est pas le même processus donc pas les mêmes données.
 */
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
