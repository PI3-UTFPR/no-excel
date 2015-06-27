package br.edu.utfpr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Crypto;
import br.edu.utfpr.util.Role;

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
	
	/**
	 * 
	 * Cria o usuário admin
	 * 
	 */
	protected void createDatabase(){
		String name = "João Rogério";
		String login = "admin";
		String password = "admin";
		UserService userService = new UserService();
		password = Crypto.encrypt(password);
		User admin = new User(name, login, password, Role.ADMIN);
		userService.save(admin);
		System.out.println("Inserido com sucesso");
	}
}
