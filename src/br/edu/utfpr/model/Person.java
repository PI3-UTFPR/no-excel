package br.edu.utfpr.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	protected String name;
		
	protected String role;
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public long getId() {
		return id;
	}	
}
