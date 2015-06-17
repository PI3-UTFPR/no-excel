package br.edu.utfpr.controller;

import java.io.IOException;
import java.util.HashMap;

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
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Crypto;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/admin/users")
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
		request.setAttribute("user", new User());
		String address = "/WEB-INF/views/admin/users.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/views/login.jsp";
		
		String login = request.getParameter("username");
		String password = Crypto.encrypt(request.getParameter("password"));
		
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);

		String err_msg = null;
		
		if(!user.isLoginValid()){
			err_msg = "Todos os campos são obrigatórios.";
		}else{
			UserService service = new UserService();
			User aux = service.getByProperty("name", user.getName());
			
			if (aux.getPassword().equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("user", aux);
			}
		}

		HashMap<String, String> msg = new HashMap<String, String>();
		if(err_msg != null){
			request.setAttribute("user", user);
			msg.put("danger", err_msg);
		}else{
			msg.put("success", "Usuário entrou no sistema!");
		}
		request.setAttribute("msg", msg);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
