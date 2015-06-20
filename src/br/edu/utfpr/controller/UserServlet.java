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
    setAllUsers(request);
    request.setAttribute("user", new User());
    String address = "/WEB-INF/views/admin/users.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }

  private void setAllUsers(HttpServletRequest request){
    UserService us = new UserService();
    request.setAttribute("users", us.findAll());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String login = request.getParameter("login");
    String password = Crypto.encrypt(request.getParameter("password"));
    User user = new User(name, login, password);

    String err_msg = null;
    if(!user.isUnique()){
      err_msg = "Login já existe.";
    }else if(!user.isValid()){
      err_msg = "Todos os campos são obrigatórios.";
    }else{
      UserService service = new UserService();
      service.save(user);
    }

    HashMap<String, String> msg = new HashMap<String, String>();
    if(err_msg != null){
      request.setAttribute("user", user);
      msg.put("danger", err_msg);
    }else{
      request.setAttribute("user", new User());
      msg.put("success", "Usuário cadastrado com sucesso");
    }
    request.setAttribute("msg", msg);

    setAllUsers(request);

    String address = "/WEB-INF/views/admin/users.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }

}
