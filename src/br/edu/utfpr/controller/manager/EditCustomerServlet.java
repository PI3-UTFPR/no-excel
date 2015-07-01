package br.edu.utfpr.controller.manager;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import javassist.expr.NewArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.Array;

import antlr.StringUtils;
import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.util.Crypto;
import br.edu.utfpr.util.MoneyUtil;
import br.edu.utfpr.util.Role;
import br.edu.utfpr.util.StringUtil;

/**
 * 
 * Editar os dados do cliente.
 * 
 * @author ronifabio
 *
 */
@WebServlet("/manager/edit-customer")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String find = request.getParameter("find");
		CustomerService customer = new CustomerService();
		
		String address = "";
	
		try {
			br.edu.utfpr.model.Customer result = null;
			
			if(this.isNumeric(find))			
				result  = customer.getByProperty("login", find.trim());
			else
				result  = customer.getByProperty("name", StringUtil.formalizeName(find.trim()));
			
			request.getSession().setAttribute("customerEdit", result);
			
			request.setAttribute("login", result.getLogin());
			request.setAttribute("name", result.getName());
			request.setAttribute("type", result.getType());
			request.setAttribute("value", MoneyUtil.formatMoney(result.getValue()));
			request.setAttribute("colleger", result.getColleger());
			
			address = "/WEB-INF/views/manager/edit-customer.jsp";
			
		} catch (Exception e) {
			HashMap<String, String> message = new HashMap<String, String>();
			
			message.put("Aviso", "Cliente não existe.");
			request.setAttribute("flashMessage", message);
			request.setAttribute("flashType", "warning");
			
			address = "/WEB-INF/views/manager/control-customer.jsp";
		}finally{
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);			
		}
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> mapParams = new HashMap<String, String>();
		HashMap<String, String> result;
		
		mapParams.put("name", StringUtil.formalizeName(request.getParameter("name").trim()));
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
				Long value = MoneyUtil.toLong(mapParams.get("value"));
				Customer editCustomer = (Customer) request.getSession().getAttribute("customerEdit");
				if(editCustomer != null){
					editCustomer.setName(mapParams.get("name"));
					editCustomer.setLogin(mapParams.get("login"));
					editCustomer.setType(mapParams.get("type"));
					editCustomer.setPassword(mapParams.get("password"));
					editCustomer.setColleger(mapParams.get("colleger"));
					editCustomer.setValue(value);
					
					customerService.update(editCustomer);
				}			

				result.put("Sucesso", "Cliente foi editado.");
				request.setAttribute("flashMessage", result);
				request.setAttribute("flashType", "success");				
			}
			
		} catch (Exception e) {
			result.put("Erro", "Erro ao salvar cliente");
			request.setAttribute("flashMessage", result);
			request.setAttribute("flashType", "danger");
		}
		finally{
			String address = "/WEB-INF/views/manager/control-customer.jsp";	
			
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
	
	private boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
