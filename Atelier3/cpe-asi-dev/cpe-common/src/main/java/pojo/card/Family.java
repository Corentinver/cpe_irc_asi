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
 * Class Entité Family
 * Elle est contenu dans le package pojo.card car cela permet au chargement de ce package, de ne créer uniquement que les tables necessaires au microservice Card.
 * Représente la table Family dans notre shéma de base de données. 
 * Elle permet la création grâce à Hibernate d'une table portant le nom de la classe et avec les attributs de celle-ci.
 */

@Entity(name="Family")
@Table(name="Family")
public class Family {
	
	
	// Correspond à l'identifiant de la table Family
	// L'annotation GeneratedValue va être quelle strategie de génération d'identifiant nous souhaitons mettre en place
	// Nous avons adopté une séquence par table.
	// Ce qui permet de gérer un identifiant qui va s'incrementer à chaque ajout dans chaque table.
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType. IDENTITY)
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

	public Family(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Family() {
		
	}
	
	
}
