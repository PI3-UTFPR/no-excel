package br.edu.utfpr.controller.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.Crypto;
import br.edu.utfpr.util.Role;

/**
 * 
 * Trata da funcionalidade de login do gerente e admin
 * 
 * @author ronifabio
 *
 */
@WebServlet("/manager/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/views/manager/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		String remind = request.getParameter("remind");
		
		UserService userService = new UserService();
		User user = userService.getByProperty("username", login);
				
		if(user != null){
			if (Crypto.checkHash(password, user.getPassword())) {
				
				/*
				 * 
				 * Encaminha para a página inicial do respectivo usuário
				 * 
				 */				
				String role = null;
				if(user.getRole().equals(Role.ADMIN)){
					role = Constants.ADMIN_PATH;				
				}
				else if(user.getRole().equals(Role.MANAGER)){
					role = Constants.MANAGER_PATH;
				}
				else{
					//somente admin e manager
					role = Constants.CLIENT_PATH;
					loginFail(request, response, login);
					return;
				}	
				
				//tempo da sessão é de 2 horas
				request.getSession().setMaxInactiveInterval(2 * 60 * 60);
				request.getSession().setAttribute(Constants.PERSON_KEY, user);
				
				String address = "/WEB-INF/views" + role + "/index.jsp";				
				RequestDispatcher dispatcher = request.getRequestDispatcher(address);
				dispatcher.forward(request, response);
			}
			else{     
				loginFail(request, response, login);
			}
		}
		else{
			loginFail(request, response,login);   
		}
	}
	
	private void loginFail(HttpServletRequest request, HttpServletResponse response, String username)throws ServletException, IOException{
		request.setAttribute("username", username);
		request.setAttribute("error", true);
		String address = "/views/manager/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
