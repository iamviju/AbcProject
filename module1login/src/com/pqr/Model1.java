package com.pqr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model1 {
	String name;
	String acc_no;
	int balance;
	String custid;
	String pwd;
	Connection con;
	PreparedStatement pstmt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public  Model1()
	{
		try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","SYSTEM","SYSTEM");
    		
    	}
    	catch(Exception e)
    	{
    		
    	}
		
	}
	 public boolean Register() throws ClassNotFoundException, SQLException
		{
	    	try 
	    	{
			pstmt = con.prepareStatement("insert into java values(?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, acc_no);
			pstmt.setInt(3, balance);
			pstmt.setString(4, custid);
			pstmt.setString(5, pwd);
			int res=pstmt.executeUpdate();
			if(res>0)
			{
				return true;
			}
			
	    	}
	    	catch(Exception e)
	    	{
	    		
	    	}
			return false;
	

         }
}
	    	
