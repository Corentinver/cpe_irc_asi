package pojo.room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.IntArrayType;


/**
 * 
 * @author Gouy Quentin
 * Class Entité Room
 * Elle est contenu dans le package pojo.room car cela permet au chargement de ce package, de ne créer uniquement que les tables necessaires au microservice Card.
 * Représente la table Room dans notre shéma de base de données. 
 * Elle permet la création grâce à Hibernate d'une table portant le nom de la classe et avec les attributs de celle-ci.
 */

@Entity(name="Room")
@Table(name="Room")
//Definition d'un type de tableau d'integer pour la structure de la base de données
@TypeDefs({
 @TypeDef(
     name = "int-array", 
     typeClass = IntArrayType.class
 )
})
public class Room {
	
	
	// Correspond à l'identifiant de la table Room
	// L'annotation GeneratedValue va être quelle strategie de génération d'identifiant nous souhaitons mettre en place
	// Nous avons adopté une séquence par table.
	// Ce qui permet de gérer un identifiant qui va s'incrementer à chaque ajout dans chaque table.
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="bet")
	private Double bet;
	
	// Correspond à un tableau d'identifiant des utilisateurs
	// Comme le base de données ne sont pas liées du au microservice, on retrouve un tableau d'identifiants liée à l'utilisateur
    // Ce tableau nous permet de récupérer les utilisateurs qui ont rejoins la partie.
    @Type(type = "int-array")
    @Column(
        name = "users",
        columnDefinition = "integer[]"
    )
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

	/**
     * Fonction pour ajouter un utilisateur à une salle
     * @param cardId Identifiant d'un utilisateur
     */
	public void addUser(Integer userId) {
		List<Integer> userList = Arrays.asList(users);
		userList = new ArrayList(userList); // A revoir
		userList.add(userId);
		users = userList.toArray(new Integer[0]);
    }

	/**
	 * Fonction pour supprimer un utilisateur d'une salle
	 * @param cardId Identifiant d'un utilisateur
	 */
    public void removeUser(Integer userId) {
    	List<Integer> userList = Arrays.asList(users);
		userList = new ArrayList(userList); // A revoir
		userList.remove(userId);
		users = userList.toArray(new Integer[0]);
    }

	public Room(Integer id, String name, Double bet, Integer[] users) {
		super();
		this.id = id;
		this.name = name;
		this.bet = bet;
		this.users = users;
	}
	
	public Room() {
		
	}

}
