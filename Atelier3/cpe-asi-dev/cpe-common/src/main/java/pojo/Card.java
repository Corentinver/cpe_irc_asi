package pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Card")
@Table(name="Card")
public class Card {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType. IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="energy")
	private int energy;
	
	@Column(name="hp")
	private int hp;
	
	@Column(name="price")
	private double price;
	
	@Column(name="path")
	private String path;
	
	@OneToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "family_id", referencedColumnName = "id")
	private Family family;
	
	@OneToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "affinity_id", referencedColumnName = "id")
	private Affinity affinity;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Affinity getAffinity() {
		return affinity;
	}

	public void setAffinity(Affinity affinity) {
		this.affinity = affinity;
	}

	public Card(Integer id, String name, String description, int energy, int hp, double price, String path,
			Family family, Affinity affinity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.energy = energy;
		this.hp = hp;
		this.price = price;
		this.path = path;
		this.family = family;
		this.affinity = affinity;
	}
	
	public Card() {
		
	}
	
	
}









