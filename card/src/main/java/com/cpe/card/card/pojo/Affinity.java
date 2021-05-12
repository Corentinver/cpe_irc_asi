package com.cpe.card.card.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Affinity")
@Table(name="Affinity")
public class Affinity {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Affinity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Affinity() {
		
	}
}
