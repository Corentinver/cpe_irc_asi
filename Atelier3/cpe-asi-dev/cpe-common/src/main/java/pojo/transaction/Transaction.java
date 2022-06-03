package pojo.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Transaction")
@Table(name="Transaction")

public class Transaction {
	
	
	// Correspond à l'identifiant de la table Transaction
	// L'annotation GeneratedValue va être quelle strategie de génération d'identifiant nous souhaitons mettre en place
	// Nous avons adopté une séquence par table.
	// Ce qui permet de gérer un identifiant qui va s'incrementer à chaque ajout dans chaque table.
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="cardId")
	private int cardId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="cardPrice")
	private double cardPrice;
	
	@Column(name="transacDate")
	private String transacDate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getcardId() {
		return cardId;
	}

	public void setName(int cardId) {
		this.cardId = cardId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public double getCardPrice() {
		return cardPrice;
	}
	
	public void setCardPrice(double cardPrice) {
		this.cardPrice = cardPrice;
	}
	
	public String getTransacDate() {
		return transacDate;
	}
	
	public void setTransacDate(String transacDate) {
		this.transacDate = transacDate;
	}

	public Transaction(int id, int userId, int cardId,  Double cardPrice, String transacDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.cardId = cardId;
		this.cardPrice = cardPrice;
		this.transacDate = transacDate;

	}
	
	public Transaction() {
		
	}

}
