package br.edu.utfpr.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.dao.UserDAO;
import br.edu.utfpr.util.JPAUtil;

public class UserService extends AbstractService<Long, User>{    
     
    public UserService(){    	        
        dao = new UserDAO();       
    }    
}


