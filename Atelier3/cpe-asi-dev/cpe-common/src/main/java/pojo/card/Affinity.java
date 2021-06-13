package pojo.card;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Gouy Quentin
 * Class Entit� Affinity
 * Elle est contenu dans le package pojo.card car cela permet au chargement de ce package, de ne cr�er uniquement que les tables necessaires au microservice Card.
 * Repr�sente la table Affinity dans notre sh�ma de base de donn�es. 
 * Elle permet la cr�ation gr�ce � Hibernate d'une table portant le nom de la classe et avec les attributs de celle-ci.
 */

@Entity(name="Affinity")
@Table(name="Affinity")
public class Affinity {
	
	// Correspond � l'identifiant de la table Affinity
	// L'annotation GeneratedValue va �tre quelle strategie de g�n�ration d'identifiant nous souhaitons mettre en place
	// Nous avons adopt� une s�quence par table.
	// Ce qui permet de g�rer un identifiant qui va s'incrementer � chaque ajout dans chaque table.
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;

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

	public Affinity(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Affinity() {
		
	}
}
