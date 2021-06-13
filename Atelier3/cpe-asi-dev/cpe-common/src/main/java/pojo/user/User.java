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


/**
 * 
 * @author Gouy Quentin
 * Class Entit� Users
 * Elle est contenu dans le package pojo.user car cela permet au chargement de ce package, de ne cr�er uniquement que les tables necessaires au microservice Card.
 * Repr�sente la table Room dans notre sh�ma de base de donn�es. 
 * Elle permet la cr�ation gr�ce � Hibernate d'une table portant le nom de la classe et avec les attributs de celle-ci.
 */
@Entity(name="User")
@Table(name = "Users")
// Definition d'un type de tableau d'integer pour la structure de la base de donn�es
@TypeDefs({
    @TypeDef(
        name = "int-array", 
        typeClass = IntArrayType.class
    )
})
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	// Correspond � l'identifiant de la table User
	// L'annotation GeneratedValue va �tre quelle strategie de g�n�ration d'identifiant nous souhaitons mettre en place
	// Nous avons adopt� une s�quence par table.
	// Ce qui permet de g�rer un identifiant qui va s'incrementer � chaque ajout dans chaque table.
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
    
    
	// Correspond � un tableau d'identifiant des utilisateurs
	// Comme le base de donn�es ne sont pas li�es du au microservice, on retrouve un tableau d'identifiants li�e � l'utilisateur
    // Ce tableau nous permet de r�cup�rer les cartes achet�es par l'utilisateur.
    @Type(type = "int-array")
    @Column(
        name = "cards",
        columnDefinition = "integer[]"
    )
    private Integer[] cards;
    

    /**
     * Fonction pour ajouter une carte � un utilisateur
     * @param cardId Identifiant d'une carte
     */
	public void addCard(Integer cardId) {
		List<Integer> cardsList = Arrays.asList(cards);
   	 	cardsList = new ArrayList(cardsList); // A revoir
        cardsList.add(cardId);
        cards = cardsList.toArray(new Integer[0]);
    }

	/**
	 * Fonction pour supprimer une carte � un utilisateur
	 * @param cardId Identifiant d'une carte
	 */
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
	
	/**
	 * Fonction qui permet de savoir si l'utilisateur � la carte ou pas
	 * Elle nous permet de v�rifier en cas de probl�me lors de suppression ou d'ajout de la carte � l'utilisateur
	 * @param cardId Identifiant de la carte 
	 * @return Savoir si elle est dedans ou pas. True or False
	 */
	public boolean containsCardId(Integer cardId) {
		List<Integer> cardList = Arrays.asList(cards);
		return cardList.contains(cardId);
	}
    
}