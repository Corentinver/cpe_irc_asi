package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Myniz
 * Class DTO UserLogin pour la connexion de l'utilisateur � notre syst�me.
 * Utiliser dans le transfer de la donn�e du c�t� client vers le c�t� serveur API.
 * Nous avons diff�renci� les DTO de la cr�ation d'un utilisateur � sa connexion 
 * Car ce n'est pas le m�me processus donc pas les m�mes donn�es.
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
