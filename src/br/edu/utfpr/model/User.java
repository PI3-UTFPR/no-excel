package br.edu.utfpr.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Person {
	
	private String ra;
	private String imageURL;
	private long balance;
	
	public User() {		
	}
	
	public User(String ra, String imageURL, Role role) {
		this.ra = ra;
		this.imageURL = imageURL;
		this.role = role;
	}
	
	public String getRa() {
		return ra;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public void setBalance(long balance) {
		this.balance = balance;
	}	
}
