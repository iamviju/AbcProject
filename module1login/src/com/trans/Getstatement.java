package com.trans;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mau.Model;


public class Getstatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Getstatement() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String acc_no= (String) session.getAttribute("acc_no");
		Model m = new Model();
		m.setAcc_no(acc_no);
		ArrayList al=m.getstatement();
		session.setAttribute("al", al);
		response.sendRedirect("/module1login/statement.jsp");
	}

}
