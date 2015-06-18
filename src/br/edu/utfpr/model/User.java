package br.edu.utfpr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.utfpr.model.service.UserService;

@Entity
public class User{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected long id;
  protected String name;
  protected String login;
  protected String password;

  public User() {
  }

  public User(String name, String login, String password) {
    this.name = name;
    this.login = login;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public boolean isUnique(){
    UserService us = new UserService();
    if(us.getByProperty("login", getLogin()) != null){
      return false;
    }
    return true;
  }

  public boolean isValid() {
    return !getName().equals("") && !getLogin().equals("") && !getPassword().equals("");
  }

}
