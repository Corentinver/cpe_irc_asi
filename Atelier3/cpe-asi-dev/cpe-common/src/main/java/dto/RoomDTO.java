package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * 
 * @author Myniz
 * Class DTO Room pour la demande de la création d'une room mais aussi la récupération des room à rejoindre via l'interface utilisateur
 * Utiliser dans le transfer de la donnée du côté client vers le côté serveur API et inversement.
 */
public class RoomDTO {
	
	// L'identifiant d'une room a été mis en read only car on ne récupère jamais l'identifiant avec le reste des données d'une room.
	// L'identifiant va être envoyé a part dans une requête
	// Nous avons donc besoin de l'identifiant lorsqu'on le renvoie vers le côté client la liste des salles
	// Cet identifiant permettra à l'utilisateur de rejoindre une room
	
	@JsonProperty(access = Access.READ_ONLY, value="id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("bet")
	private Double bet;

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

	public RoomDTO(Integer id, String name, Double bet) {
		super();
		this.id = id;
		this.name = name;
		this.bet = bet;
	}
	
	
	
	
}
