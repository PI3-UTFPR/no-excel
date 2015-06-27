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
import javax.servlet.http.HttpSession;

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
@WebServlet("/manager/logout")
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/manager/login.jsp");
	}	
}
