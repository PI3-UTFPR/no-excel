package br.edu.utfpr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.UserService;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/area-do-cliente")
public class CustomerAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/views/customer/login.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String login_form = request.getParameter("login");
		String senha_form = request.getParameter("password");
		CustomerService us = new CustomerService();
		
		Customer u = us.getByProperty("login", login_form);
		if(u != null ){
			if(u.getPassword().equals(senha_form)){
			
				HttpSession session = request.getSession();
				session.setAttribute("is_loged", true);
				
				String address = "/WEB-INF/views/customer/index.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(address);
				dispatcher.forward(request, response);
			
			}else{
				loginFail(request, response,login_form);
			}
		}else{
			loginFail(request, response,login_form);   
		}
		
	}
	
	private void loginFail(HttpServletRequest request, HttpServletResponse response, String username)throws ServletException, IOException{
		request.setAttribute("username", username);
		request.setAttribute("error", true);
		String address = "/WEB-INF/views/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
