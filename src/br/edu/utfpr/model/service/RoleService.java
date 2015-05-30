package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Role;
import br.edu.utfpr.model.dao.RoleDAO;
import br.edu.utfpr.util.JPAUtil;

public class RoleService extends AbstractService<Long, Role>{

	public RoleService() {		        
        dao = new RoleDAO();
	}
}
