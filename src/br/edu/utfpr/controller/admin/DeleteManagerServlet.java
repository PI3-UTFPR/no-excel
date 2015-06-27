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

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.Role;

/**
 * 
 * Remove um gerente da base de dados.
 * 
 * @author ronifabio
 *
 */
@WebServlet("/admin/delete-manager")
public class DeleteManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		UserService us = new UserService();
		User user = us.getById(Long.parseLong(id));
		
		HashMap<String, String> msg = new HashMap<String, String>();
		if(user != null){
			System.out.println("Removendo o usuario " + user.getName());
			boolean isSuccess = us.delete(user);
			
			if(isSuccess){
				msg.put("success", "O gerente " + user.getName() + " foi excluído com sucesso!");
			}
			else{
				msg.put("danger", "O usuário gerente não pode ser removido.");
			}
		}
		else{
			msg.put("danger", "O usuário gerente não existe.");
		}
	    
	    setAllUsers(request, us);	    
	    request.setAttribute("msg", msg);
	    
	    String address = "/WEB-INF/views/admin/register-manager.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.forward(request, response);
	}
	
	/**
	 * 
	 * Realiza a busca por todos os gerentes cadastrados e guarda no escopo.
	 * 
	 * @param request
	 */
	private void setAllUsers(HttpServletRequest request, UserService userService){		
		List<User> userList = userService.findAll();
		List<User> managerList = new ArrayList<User>();
		
		//filtra apenas os usuários com papel de gerente
		for(User user : userList){
			if(user.getRole().equals(Role.MANAGER)){
				managerList.add(user);
			}
		}
		
		request.setAttribute(Constants.MANAGER_LIST_KEY, managerList);
	}

}
