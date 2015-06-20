package br.edu.utfpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String ra;
	private String type;
	private String value;
	private String password;
	private String colleger;
	
	
	public Customer(){
		
	}
	
	public Customer(String name, String ra, String type, String value, String password, String colleger){
		this.name = name;
		this.ra = ra;
		this.type = type;
		this.value = value;
		this.password = password;
		this.colleger = colleger;
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

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getColleger() {
		return colleger;
	}

	public void setColleger(String colleger) {
		this.colleger = colleger;
	}

}
