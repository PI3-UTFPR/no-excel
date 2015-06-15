package br.edu.utfpr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.service.CustomerService;
/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/cliente")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/views/customer/registerCustomer.jsp";		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String ra = request.getParameter("ra");
		String type = request.getParameter("type");
		String value = request.getParameter("value");
		
		CustomerService customerService = new CustomerService();
		try {
			customerService.save(new Customer(name, ra, type, value));
			request.setAttribute("flash-message", "Salvo com sucesso");
		} catch (Exception e) {
			request.setAttribute("flash-message", "Erro ao salvar");
		}finally{
			String address = "/WEB-INF/views/customer/registerCustomer.jsp";		
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}

	}
}
