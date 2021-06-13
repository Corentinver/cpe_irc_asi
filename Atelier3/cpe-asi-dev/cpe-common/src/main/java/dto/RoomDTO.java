package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * 
 * @author Myniz
 * Class DTO Room pour la demande de la cr�ation d'une room mais aussi la r�cup�ration des room � rejoindre via l'interface utilisateur
 * Utiliser dans le transfer de la donn�e du c�t� client vers le c�t� serveur API et inversement.
 */
public class RoomDTO {
	
	// L'identifiant d'une room a �t� mis en read only car on ne r�cup�re jamais l'identifiant avec le reste des donn�es d'une room.
	// L'identifiant va �tre envoy� a part dans une requ�te
	// Nous avons donc besoin de l'identifiant lorsqu'on le renvoie vers le c�t� client la liste des salles
	// Cet identifiant permettra � l'utilisateur de rejoindre une room
	
	@JsonProperty(access = Access.READ_ONLY, value="id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("bet")
	private Double bet;
	
	@JsonProperty("users")
	private Integer[] users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBet() {
		return bet;
	}

	public void setBet(Double bet) {
		this.bet = bet;
	}

	public Integer[] getUsers() {
		return users;
	}

	public void setUsers(Integer[] users) {
		this.users = users;
	}

	public RoomDTO(Integer id, String name, Double bet, Integer[] users) {
		super();
		this.id = id;
		this.name = name;
		this.bet = bet;
		this.users = users;
	}
	
	public RoomDTO() {
		
	}
	
}
