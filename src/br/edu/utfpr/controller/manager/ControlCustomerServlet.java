package br.edu.utfpr.controller.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Controla o acesso a página de cadastro do cliente.
 * Apenas os administradores têm acesso.
 * 
 * @author ronifabio
 *
 */
@WebServlet("/manager/control-customer")
public class ControlCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/views/manager/control-customer.jsp";		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		String address = "/WEB-INF/views/manager/control-customer.jsp";		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	};
}
