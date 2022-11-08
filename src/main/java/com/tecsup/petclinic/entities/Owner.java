package com.tecsup.petclinic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "owners")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String lastName;
	
	public Owner() {
	}

	public Owner(long id, String name, String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}

	public Owner(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlastName() {
		return name;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", lastName=" + lastName + "]";
	}
}
