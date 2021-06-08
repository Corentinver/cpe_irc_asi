package pojo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.IntArrayType;

@Entity(name="User")
@Table(name = "Users")
@TypeDefs({
    @TypeDef(
        name = "int-array", 
        typeClass = IntArrayType.class
    )
})
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
    
    @Type(type = "int-array")
    @Column(
        name = "cards",
        columnDefinition = "integer[]"
    )
    private Integer[] cards;
    

	public void addCard(Integer cardId) {
		List<Integer> cardsList = Arrays.asList(cards);
   	 	cardsList = new ArrayList(cardsList); // A revoir
        cardsList.add(cardId);
        cards = cardsList.toArray(new Integer[0]);
    }

    public void removeCard(Integer cardId) {
    	 List<Integer> cardsList = Arrays.asList(cards);
    	 cardsList = new ArrayList(cardsList);
         cardsList.remove(cardId);
         cards = cardsList.toArray(new Integer[0]);
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
	
	public Integer[] getCards() {
		return cards;
	}

	public void setCards(Integer[] cards) {
		this.cards = cards;
	}

	public User(Integer userId, String password, String surname, String name, double money, Integer[] cards) {
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
	
	public boolean containsCardId(Integer cardId) {
		List<Integer> cardList = Arrays.asList(cards);
		return cardList.contains(cardId);
	}
    
}