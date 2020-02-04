package com.trans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Loan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Loan() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pamount = Integer.parseInt(request.getParameter("pamount"));
		int time = Integer.parseInt(request.getParameter("time"));
		double rate = .12;
		double simple_interest = pamount*time*rate;
		HttpSession session = request.getSession();
		session.setAttribute("pamount", pamount);
		session.setAttribute("time", time);
		session.setAttribute("rate", rate*100);
		session.setAttribute("simple_interest", simple_interest);
		response.sendRedirect("/module1login/loan.jsp");
	}

}
