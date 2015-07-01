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
//import javax.websocket.Session;
import javax.servlet.http.HttpSession;

import javax.websocket.Session;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.Role;

/**
 * 
 * Encaminha para a tela inicial do admin.
 * 
 * @author ronifabio
 *
 */
@WebServlet("/admin")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Encaminhando para a inicial do admin - get");

		String address = "/WEB-INF/views/admin/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String ra = request.getParameter("ra");
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getByProperty("colleger", ra);


		if (customer != null) {
		
			request.getSession().setAttribute("customer", customer);
//			System.out.println(customer);
		
		} else {
			request.getSession().setAttribute("customer", null);

			String msg = "Aluno não encontrado!";
			System.out.println(msg);
			
		}



		
		System.out.println("Encaminhando para a inicial do admin - post");
		String address = "/WEB-INF/views/admin/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);

	}
}
