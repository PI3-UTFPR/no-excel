package br.edu.utfpr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.RoleService;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Crypto;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/views/user_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/views/user_form.jsp";
		
		UserService us = new UserService();
		User user = us.getByProperty("ra", (String) request.getAttribute("username"));
		
		String pass = Crypto.encrypt((String) request.getAttribute("password"));
		
		if(user.getPassword().equals(pass)) {
			if (user.getRole().getType().equals("admin"))
				address = "/views/admin.jsp";
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
		
		response.sendRedirect(address);
	}

}
