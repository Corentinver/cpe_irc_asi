package com.cpe.card.card.dto;

public class OwnedCard {

	public int userId;
	public int cardId;
	
	public OwnedCard(int userId, int cardId) {
		
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
}
