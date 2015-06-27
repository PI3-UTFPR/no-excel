package br.edu.utfpr.filter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

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
 * Filtra as requisições ao contexto do cliente
 * 
 * @author ronifabio
 *
 */
@WebFilter(filterName = "CustomerFilter", urlPatterns = {"/customer"} )
public class CustomerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CustomerFilter() {

    }
	
	public void destroy() {

	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
				
		/*
		 * 
		 * Verifica se o usuário está logado.
		 * Se estiver, apenas permite o acesso caso tenha o papel de cliente.
		 * Caso não seja, encaminha para a tela de login.
		 * 
		 */		
		HttpSession session = ((HttpServletRequest) request).getSession();
		Person user = (Person)session.getAttribute(Constants.PERSON_KEY); 

		//recupera a url do contexto
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String contextPath = httpRequest.getContextPath();	
		
		if(user == null){			
			httpResponse.sendRedirect(contextPath + "/views/login.jsp");
		}
		else if(user.getRole().equals(Role.CLIENT)){
			//permite o acesso			
			chain.doFilter(request, response);
		}
		else{
			//envia para a página de acesso negado
			System.out.println("O acesso é negado!");
			String address = contextPath + "/error/accessDenied.jsp";
			httpResponse.sendRedirect(address);
		}		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}
}
