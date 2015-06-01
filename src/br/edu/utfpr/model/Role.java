package br.edu.utfpr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	public static final String ADMIN = "admin";
	public static final String USER = "user";
	public static final String CLIENT = "client";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	
	@Column(nullable=false, unique=true)
	private String type;
	
	public Role() {
	}
	
	public Role(String type) {
		this.type = type;
	}
	
	public long getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
