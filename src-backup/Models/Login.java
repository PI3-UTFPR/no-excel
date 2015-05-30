package Models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Util.Crypto;

public class Login {
	
	public boolean checkLogin(String username, String password){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("noexcel");
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT u FROM User u WHERE u.username = :username";
		
		Query q = em.createQuery(query);
		q.setParameter("username", username);		

		List<User> user = q.getResultList();
		Crypto crypto = new Crypto();
		
		if(user.size() == 1){
			for (User u : user)
				if(crypto.checkHash(password, u.getPassword()))
					return true;
		}
		
		return false;		
	}

}
