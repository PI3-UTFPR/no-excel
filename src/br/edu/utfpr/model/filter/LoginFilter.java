package br.edu.utfpr.model.filter;

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

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/disabled"} )
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		Implementar verificação se está logado
		boolean loggedIn = true;
		String role = null;
		HttpSession session = ((HttpServletRequest) request).getSession();
		if(session.getAttribute("customerLogin") != null){
			role = "customer";
		// Manager
		}else if(session.getAttribute("user") != null){
			role = "user";
		// Admin
		}else if(session.getAttribute("username") != null){
			role = "admin";
		}
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String contextPath = ((HttpServletRequest)request).getContextPath();
		
		
		if(role == null){
			System.out.println("teste01");
			httpResponse.sendRedirect(contextPath + "/login");
		}else{
			String url = ((HttpServletRequest)request).getRequestURI();
			if(role.equals("customer")){
				String checkUrl = contextPath + "/area-do-cliente";
				if(!url.startsWith(checkUrl)){
					System.out.println("teste02");
					httpResponse.sendRedirect(contextPath + "/area-do-cliente");
					return;
				}
			}else if(role.equals("user")){
				String checkUrl = contextPath + "/user";
				if(!url.startsWith(checkUrl)){
					httpResponse.sendRedirect(((HttpServletRequest)request).getContextPath() + "/user");
					return;
				}
			}else if(role.equals("admin")){
				if(!url.startsWith(contextPath + "/user") || !url.startsWith(contextPath + "/admin")){
					httpResponse.sendRedirect(((HttpServletRequest)request).getContextPath() + "/admin");
					return;
				}
			}
			
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
