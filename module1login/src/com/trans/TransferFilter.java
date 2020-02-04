package com.trans;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TransferFilter implements Filter {

    
    public TransferFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 int amount = Integer.parseInt(request.getParameter("amount"));
		 HttpSession session = ((HttpServletRequest) request).getSession();
		int balance = (int) session.getAttribute("balance");
		 if(balance>amount)
		 {
			 chain.doFilter(request, response);
		 }
		 else 
		 {
			 ((HttpServletResponse) response).sendRedirect("/module1login/notenough.html");
		 }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
