package Controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.User;
import Util.Crypto;
import Util.JPAUtil;
import Util.UserDAO;

/**
 * Servlet implementation class CreateAdminServlet
 */
@WebServlet("/admin1/users/create")
public class CreateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAdminServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/views/createAdmin.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("noexcel");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		String password = new Crypto().encrypt("321");
		User user = new User("felipe", "gomes", password);
		em.persist(user);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
//		try{
//			UserDAO userDAO = new UserDAO(JPAUtil.getEntityManager());
//			userDAO.save(new User(name, login, password));
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}

}
