package Util;

import javax.persistence.EntityManager;

import Models.User;

public class UserDAO extends AbstractDAO<Long, User>{

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
