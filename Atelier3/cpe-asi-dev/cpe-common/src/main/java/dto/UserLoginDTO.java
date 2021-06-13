package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Myniz
 * Class DTO UserLogin pour la connexion de l'utilisateur à notre système.
 * Utiliser dans le transfer de la donnée du côté client vers le côté serveur API.
 * Nous avons différencié les DTO de la création d'un utilisateur à sa connexion 
 * Car ce n'est pas le même processus donc pas les mêmes données.
 */
public class UserLoginDTO {
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("password")
	private String password;
	
	public UserLoginDTO() {
	}
	
	public UserLoginDTO(String surname, String password) {
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
