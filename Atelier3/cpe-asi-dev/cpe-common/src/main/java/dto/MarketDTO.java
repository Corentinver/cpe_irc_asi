package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Myniz
 * Class DTO Market pour la demande d'un achat
 * Utiliser dans le transfer de la donn?e du c?t? client vers le c?t? serveur API
 */
public class MarketDTO {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("cardId")
	private int cardId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	public MarketDTO() {
		
	}

	public MarketDTO(int id, int cardId) {
		super();
		this.id = id;
		this.cardId = cardId;
	}
	
	
}
