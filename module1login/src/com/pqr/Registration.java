package com.pqr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String name = request.getParameter("name");
			String acc_no = request.getParameter("acc_no");
			int balance = Integer.parseInt(request.getParameter("balance"));
			String custid = request.getParameter("custid");
			String pwd =request.getParameter("pwd");
			Model1 m1 = new Model1();
			m1.setName(name);
			m1.setAcc_no(acc_no);
			m1.setBalance(balance);
			m1.setCustid(custid);
			m1.setPwd(pwd);
			boolean status1 = m1.Register();
			if(status1)
			{
				response.sendRedirect("/module1login/registersuccess.html");
			}
			else
			{
				response.sendRedirect("/module1login/failure.html");
			}
			
		}
		catch(Exception e)
		{
			
		}
	}

}
