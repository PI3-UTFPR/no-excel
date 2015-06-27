package br.edu.utfpr.controller;

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

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.Crypto;
import br.edu.utfpr.util.Role;

/**
 * 
 * Trata da funcionalidade de login do cliente
 * 
 * @author ronifabio
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/views/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Tratando o login do cliente");
		
		String login = request.getParameter("username");
		String password = request.getParameter("password");
				
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getByProperty("login", login);
				
		if(customer != null){
			if (Crypto.checkHash(password, customer.getPassword())) {
								
				//tempo da sessão é de 2 horas
				request.getSession().setMaxInactiveInterval(2 * 60 * 60);
				request.getSession().setAttribute(Constants.PERSON_KEY, customer);
				
				/*
				 * 
				 * Encaminha para a página inicial do respectivo usuário
				 * 
				 */				
				//String address = "/WEB-INF/views" + Constants.CLIENT_PATH + "/index.jsp";
				String address = Constants.CLIENT_PATH;				
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + address);
				
				//RequestDispatcher dispatcher = request.getRequestDispatcher(address);
				//dispatcher.forward(request, response);
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
		String address = "/views/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}
