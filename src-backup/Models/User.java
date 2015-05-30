package Models;

import javax.persistence.Entity;

@Entity
public class User extends Person{
	private String username;
	private String password;
	
	public User(){}
	
	public User(String name, String login, String password){
		setName(name);
		setUsername(login);
		setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
