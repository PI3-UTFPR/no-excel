package br.edu.utfpr.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/admin/users/delete")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UserService us = new UserService();
		User user = us.getById(Long.parseLong(id));
		
		HashMap<String, String> msg = new HashMap<String, String>();
		if(user != null){
			us.delete(user);
			msg.put("success", "Usuário excluído com sucesso.");
		}else{
			msg.put("danger", "Usuário não existe.");
		}
	    
	    request.setAttribute("users", us.findAll());
	    request.setAttribute("user", new User());
	    request.setAttribute("msg", msg);
	    
	    String address = "/WEB-INF/views/admin/users.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
