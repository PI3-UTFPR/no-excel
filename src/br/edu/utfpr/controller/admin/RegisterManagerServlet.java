package br.edu.utfpr.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.Crypto;
import br.edu.utfpr.util.Role;

/**
 * 
 * Cadastra usuários com o perfil de gerente para o restaurante
 * 
 * @author ronifabio
 *
 */
@WebServlet("/admin/register-manager")
public class RegisterManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAllUsers(request);		
		String address = "/WEB-INF/views/admin/register-manager.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * 
	 * Realiza a busca por todos os gerentes cadastrados e guarda no escopo.
	 * 
	 * @param request
	 */
	private void setAllUsers(HttpServletRequest request){
		UserService userService = new UserService();
		List<User> userList = userService.findAll();
		List<User> managerList = new ArrayList<User>();
		
		//filtra apenas os usuários com papel de gerente
		for(User user : userList){
			if(user.getRole().equals(Role.MANAGER)){
				managerList.add(user);
			}
		}
		
		request.setAttribute(Constants.MANAGER_LIST_KEY, managerList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = Crypto.encrypt(request.getParameter("password"));
		User user = new User(name, login, password, Role.MANAGER);
		
		/*
		 * 
		 * Verifica se o username já existe
		 * 
		 */
		UserService userService = new UserService();
		User tmpUser = userService.getByProperty("username", login);

		String err_msg = null;
		if(tmpUser != null){
			err_msg = "O nome de usuário especificado já existe!";
		}
		else if(!user.isValid()){
			err_msg = "Todos os campos são obrigatórios.";
		}else{			
			userService.save(user);
		}

		HashMap<String, String> messageMap = new HashMap<String, String>();
		if(err_msg != null){
			request.setAttribute("user", user);
			messageMap.put("danger", err_msg);
		}
		else{			
			messageMap.put("success", "Usuário cadastrado com sucesso");
		}
		request.setAttribute("msg", messageMap);

		setAllUsers(request);

		String address = "/WEB-INF/views/admin/register-manager.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}
