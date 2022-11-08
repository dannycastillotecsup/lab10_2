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
	private String first_name;
	private String last_name;
	private String adress;
	private String city;
	private String telephone;
	
	public Owner() {
	}

	public Owner(long id, String first_name, String last_name, String adress, String city, String telephone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Owner(String first_name, String last_name, String adress, String city, String telephone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getlastName() {
		return last_name;
	}

	public void setlastName(String last_name) {
		this.last_name = last_name;
	}

	public String getAdress() {
		return last_name;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + first_name + ", lastName=" + last_name + ", adress=" + adress +", city=" + city +", telephone=" + telephone +"]";
	}
}
