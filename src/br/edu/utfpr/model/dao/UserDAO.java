package br.edu.utfpr.model.dao;

import javax.persistence.EntityManager;

import br.edu.utfpr.model.User;

public class UserDAO extends AbstractDAO<Long, User>{
	
	public UserDAO() {
        super();
    }
}
