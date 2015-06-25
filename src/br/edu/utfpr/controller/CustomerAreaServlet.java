package br.edu.utfpr.controller;

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
import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.TransactionService;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Crypto;

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
		HttpSession session = request.getSession();
		
		if (request.getParameter("logout") != null) {  
		    session.invalidate();
		    response.sendRedirect("area-do-cliente");
		    return; // <--- Here.
		}		
		
		try{
			Boolean b = (Boolean) session.getAttribute("is_loged");
			if(b){
				if(session.getAttribute("customerId") != null){
					address = "/WEB-INF/views/customer/index.jsp";
				}else{
					Customer c = this.loadCustomer((String) session.getAttribute("customerLogin"));
					
					TransactionService ts = new TransactionService();
					ArrayList<Transaction> listTrans = (ArrayList<Transaction>) ts.findAllById("customer", c.getId());
					
					request.setAttribute("transactions", listTrans);
					request.setAttribute("customer", c);
					
					address = "/WEB-INF/views/customer/index.jsp";
				}
			}
		}catch(Exception e){
			System.out.println("sem login");
			address = "/WEB-INF/views/customer/login.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String login_form = request.getParameter("login");
		String senha_form = request.getParameter("password");
		Customer c = this.loadCustomer(login_form);
		
		
		if(c != null ){
			if (Crypto.checkHash(senha_form, c.getPassword())) {
				TransactionService ts = new TransactionService();
				String strLong = Long.toString(c.getId());
				System.out.println(c.getId());
				ArrayList<Transaction> listTrans = (ArrayList<Transaction>) ts.findAllById("customer", c.getId());
				
				HttpSession session = request.getSession();
				session.setAttribute("is_loged", true);
				session.setAttribute("customerLogin", login_form);
				
				request.setAttribute("transactions", listTrans);
				request.setAttribute("customer", c);
				//request.setAttribute("transactions", );
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
	
	private Customer loadCustomer(String login){
		
		CustomerService cs = new CustomerService();
		Customer c = cs.getByProperty("login", login);
		return c;
	}

}
