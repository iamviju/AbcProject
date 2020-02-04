package com.trans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mau.Model;


public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Transfer() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amount =Integer.parseInt(request.getParameter("amount"));
		String account =request.getParameter("account");
		
		HttpSession session = request.getSession();
		String acc_no= (String) session.getAttribute("acc_no");
		int balance = (int) session.getAttribute("balance");
		
		Model m = new Model();
		m.setAmount(amount);
		m.setAcc_no(acc_no);
		m.setBalance(balance);
		m.setAccount(account);
		
		boolean status3 = m.transfer();
		if(status3)
		{
			
			
			response.sendRedirect("/module1login/successtransfer.html");
		}
		else
		{
			response.sendRedirect("/module1login/failuretransfer.html");
		}
		
	}

}
