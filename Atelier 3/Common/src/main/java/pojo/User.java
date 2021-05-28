package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="User")
@Table(name = "Users")
public class User implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType. IDENTITY)
    private Integer userId;
    
    @Column(name="password")
    private String password;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name="name")
    private String name;
    
    @Column(name="money")
    private double money;
    
    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
    		name = "users_card",
    		joinColumns = @JoinColumn(name = "users_id"),
    		inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    List<Card> cards = new ArrayList<>();
    

	public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
    	cards.remove(card);
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public User(Integer userId, String password, String surname, String name, double money, List<Card> cards) {
		super();
		this.userId = userId;
		this.password = password;
		this.surname = surname;
		this.name = name;
		this.money = money;
		this.cards = cards;
	}
	
	public User() {
		
	}
    
    
}