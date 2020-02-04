package com.tuv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mau.Model;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		String custid = request.getParameter("custid");
		String pwd =request.getParameter("pwd");
		Model m = new Model();
		m.setCustid(custid);
		m.setPwd(pwd);
		boolean status =m.login();
		String acc_no = m.getAcc_no();
		int balance = m.getBalance();
		
		if(status)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("acc_no", acc_no);
			session.setAttribute("balance", balance);
			
			response.sendRedirect("/module1login/success.html");
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
