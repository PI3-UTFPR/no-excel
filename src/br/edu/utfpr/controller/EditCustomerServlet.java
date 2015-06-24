package br.edu.utfpr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.util.Crypto;

/**
 * Servlet implementation class CustomerEditServlet
 */
@WebServlet("/admin/customers/edit")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String find = request.getParameter("find");
		CustomerService customer = new CustomerService();
		
		String address = "";
	
		try {
			
			br.edu.utfpr.model.Customer result  = customer.getByProperty("login", find.trim());
			request.setAttribute("login", result.getLogin());
			request.setAttribute("name", result.getName());
			request.setAttribute("password", result.getPassword());
			request.setAttribute("type", result.getType());
			request.setAttribute("value", result.getValue());
			request.setAttribute("colleger", result.getColleger());
			address = "/WEB-INF/views/customer/editCustomer.jsp";
			
		} catch (Exception e) {
			HashMap<String, String> message = new HashMap<String, String>();
			message.put("Aviso", "Cliente não existe.");
			request.setAttribute("flashMessage", message);
			request.setAttribute("flashType", "warning");
			address = "/WEB-INF/views/customer/manageCustomer.jsp";
		}finally{
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);			
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> mapParams = new HashMap<String, String>();
		HashMap<String, String> result;
		
		mapParams.put("name", request.getParameter("name"));
		mapParams.put("login", request.getParameter("login"));
		mapParams.put("type", request.getParameter("type"));
		mapParams.put("value", request.getParameter("value"));
		mapParams.put("password", Crypto.encrypt(request.getParameter("password")));
		mapParams.put("colleger", request.getParameter("colleger"));
		
		result = verifyParameters(mapParams);
		

		
		try {
			if(result.size() > 0){
				request.setAttribute("flashMessage", result);
				request.setAttribute("flashType", "warning");
			}else{
				CustomerService customerService = new CustomerService();
				customerService.update(new Customer(
						mapParams.get("name"),
						mapParams.get("login"),
						mapParams.get("type"),
						mapParams.get("value"),
						mapParams.get("password"),
						mapParams.get("colleger")
					)
				);
				result.put("Sucesso", "Cliente foi editado.");
				request.setAttribute("flashMessage", result);
				request.setAttribute("flashType", "success");				
			}
			
		} catch (Exception e) {
			result.put("Erro", "Erro ao salvar cliente");
			request.setAttribute("flashMessage", result);
			request.setAttribute("flashType", "danger");
		}finally{
			String address = "/WEB-INF/views/customer/managerCustomer.jsp";		
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}		
	}

	/**
	 * 
	 * @param parameters
	 * @return
	 */
	private HashMap<String, String> verifyParameters(HashMap<String, String> parameters){

		HashMap<String, String> result = new HashMap<String, String>();
		
		for (Entry<String, String> entry : parameters.entrySet()) {
			
			switch (entry.getKey().toString()) {
				case "name":
					String[] splitname = entry.getValue().split(" ");
					if(splitname.length < 2)
						result.put("Nome", "É necessário nome e sobrenome.");
				break;
				case "login":
					if(entry.getValue().length() == 0)
						result.put("Login", "Valor está em branco.");
				break;
				case "type":
					if(entry.getValue().length() == 0)
						result.put("Tipo de Pessoa", "Valor está em branco.");
				break;
				case "value":
					if(entry.getValue().length() == 0)
						result.put("Valor", "Valor está em branco.");
				break;
				case "colleger":
					if(entry.getValue().length() == 0)
						result.put("Bolsista", "Valor está em branco.");
				break;
				case "password":
					if(entry.getValue().length() == 0)
						result.put("Password", "Valor está em branco.");
				break;				
			}
		}		
				
		return result;
	}
	

}
