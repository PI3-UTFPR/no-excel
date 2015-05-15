package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Login;
import Models.User;
import Util.Crypto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>TESTE</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		
		Login login = new Login();
		
		if(login.checkLogin(username, password))
			out.println("<h1>Usuário logado com sucesso</h1>");
		else
			out.println("<h1>Erro no login dados inválidos</h1>");
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("noexcel");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		String password = new Crypto().encrypt("321");
		System.out.println(password);
		User user = new User("felipe", "gomes", password);
		em.persist(user);
		
		em.getTransaction().commit();
		em.close();
		emf.close();*/
	}

}
