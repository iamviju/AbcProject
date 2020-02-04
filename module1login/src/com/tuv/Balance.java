package com.tuv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mau.Model;


public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Balance() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String acc_no= (String) session.getAttribute("acc_no");
		Model m = new Model();
		m.setAcc_no(acc_no);
		boolean status = m.checkbalance();
		int balance =m.getBalance();		
		if(status)
		{
			session.setAttribute("balance", balance);
			response.sendRedirect("/module1login/checksuccess.jsp");
			
		}
		else
		{
			response.sendRedirect("/module1login/failure.html");
		}
		
		
	}

}
