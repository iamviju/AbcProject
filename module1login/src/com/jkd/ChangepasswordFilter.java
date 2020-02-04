package com.jkd;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class ChangepasswordFilter implements Filter {

    
    public ChangepasswordFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 String npwd = (request.getParameter("npwd"));
		 String cnpwd = (request.getParameter("cnpwd"));
		 if(cnpwd.equals(npwd))
		 {
		     chain.doFilter(request, response);
	     }
		 else
		 {
			((HttpServletResponse) response).sendRedirect("/module1login/error.html");
		 }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
