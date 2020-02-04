package com.jkd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mau.Model;


public class Changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Changepassword() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String npwd = request.getParameter("npwd");
			String cnpwd = request.getParameter("cnpwd");
			HttpSession session = request.getSession();
			String acc_no= (String) session.getAttribute("acc_no");
			Model m = new Model();
			m.setNpwd(npwd);
			m.setAcc_no(acc_no);
			boolean status1 = m.changepwd();
			if(status1)
			{
				
				
				response.sendRedirect("/module1login/successpwd.html");
			}
			else
			{
				response.sendRedirect("/module1login/failurepwd.html");
			}
		}
			
			catch(Exception e)
			{
				
			}
		
	}

}
