package br.edu.utfpr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.Person;
import br.edu.utfpr.model.User;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.Role;

/**
 * 
 * Encaminha o usuário para a área do cliente caso já esteja logado
 * ou para a página de login.
 * 
 * Caso o usuário seja admin ou manager, encaminha para as suas respectivas páginas iniciais.
 * 
 * @author ronifabio
 *
 */
@WebFilter(filterName = "GeneralFilter", urlPatterns = {"/"} )
public class GeneralFilter implements Filter {

    /**
     * Default constructor. 
     */
    public GeneralFilter() {

    }
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/*
		 * 
		 * Verifica se o usuário está logado.
		 * Se estiver, se for cliente, encaminha para sua página inicial.
		 * Se estiver, se for gerente ou admin, encaminha para sua pagina inicial.
		 * Se não estiver logado, encaminha para a página de login do cliente.
		 * 
		 * A página default é do cliente.
		 * 
		 */		
		HttpSession session = ((HttpServletRequest) request).getSession();
		Person user = (Person)session.getAttribute(Constants.PERSON_KEY); 

		//recupera a url do contexto
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String contextPath = httpRequest.getContextPath();	
		
		if(user == null){
			System.out.println("GeneralFilter -> usuário não encontrado na sessão");
			if(httpRequest.getRequestURI().contains(Constants.ADMIN_PATH)){
				System.out.println("GeneralFilter -> é admin");
				
				//encaminha para a página inicial do admin
				String address = Constants.ADMIN_PATH;
				httpResponse.sendRedirect(contextPath + address);								
			}
			else if(httpRequest.getRequestURI().contains(Constants.MANAGER_PATH)){
				System.out.println("GeneralFilter -> é manager");
				
				//encaminha para a página inicial do gerente
				String address = Constants.MANAGER_PATH;
				httpResponse.sendRedirect(contextPath + address);				
			}
			else{
				System.out.println("GeneralFilter -> envia para o login default");
				httpResponse.sendRedirect(contextPath + "/views/login.jsp");
			}			
		}
		else {
			
			if(httpRequest.getRequestURI().contains(Constants.ADMIN_PATH) || httpRequest.getRequestURI().contains(Constants.MANAGER_PATH)){
				//encaminha para os próximos filtros caso seja manager ou admin			
				chain.doFilter(request, response);
			}
			else{
				//encaminha para a tela inicial do cliente
				String address = "/WEB-INF/views/customer/index.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(address);
				dispatcher.forward(request, response);
			}		
		}		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
