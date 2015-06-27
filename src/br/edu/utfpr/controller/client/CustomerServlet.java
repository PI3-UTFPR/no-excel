package br.edu.utfpr.controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.Person;
import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.TransactionService;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.Crypto;

/**
 * 
 * Controla a tela inicial do cliente.
 * 
 * @author ronifabio
 *
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = null;
		HttpSession session = request.getSession();
		
		Person customer = (Person)session.getAttribute(Constants.PERSON_KEY);
		
		if (request.getParameter("logout") != null) {  
			session.invalidate();
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/login.jsp");
			return; // <--- Here.
		}
		
		if(customer == null){
			address = "/views/login.jsp";
		}
		else{
			address = "/WEB-INF/views/customer/index.jsp";
			
			TransactionService transactionService = new TransactionService();
			ArrayList<Transaction> transactionList = (ArrayList<Transaction>) transactionService.findAllById("customer_id", customer.getId());

			request.setAttribute("transactions", transactionList);
		}	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	
}
