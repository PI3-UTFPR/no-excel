package br.edu.utfpr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.Role;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.RoleService;
import br.edu.utfpr.model.service.UserService;

@WebServlet("/CreateDatabaseServlet")
public class CreateDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateDatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createDatabase();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createDatabase();
	}
	
	private void createDatabase(){		
		UserService userService = new UserService();
		RoleService roleService = new RoleService();
		Role adminRole = new Role(Role.ADMIN);
		roleService.save(adminRole);
		adminRole = roleService.getByProperty("type", Role.ADMIN);
		userService.save(new User("112", "URL", adminRole));
	}

}
