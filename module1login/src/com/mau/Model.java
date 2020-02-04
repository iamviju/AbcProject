package com.mau;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Model {
	
	String name;
	String acc_no;
	int balance;
	String custid;
	String pwd;
	String npwd;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int rs1;
	int amount;
	int rs2;
	int  rs4;
	String account;
	ResultSet rs3;
	int newbalance;
	ResultSet rs5;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	String acc_no1;
	PreparedStatement pstmt1;
	
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
    public String getNpwd() {
		return npwd;
	}
    public void setNpwd(String npwd) {
		this.npwd = npwd;
	}
    public int getAmount() {
		return amount;
	}
    public void setAmount(int amount) {
		this.amount = amount;
	}
   
    public Model()
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


    public boolean login() throws ClassNotFoundException, SQLException
	{
    	try 
    	{
		pstmt = con.prepareStatement("select * from java where custid=? and pwd=?");
		pstmt.setString(1, custid);
		pstmt.setString(2, pwd);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			balance = rs.getInt(3);
			acc_no =rs.getString(2);
			
			return true;
		}
    	}
    	catch(Exception e)
    	{
    		
    	}
		return false;
    	
	}
    public boolean checkbalance()
    {
    	try
    	{
    	pstmt = con.prepareStatement("select * from java where acc_no=?");
    	pstmt.setString(1, acc_no);
    	rs = pstmt.executeQuery();
    	while(rs.next())
    	{
    		balance = rs.getInt(3);
    		return true;
    	}
    	}
    	catch(Exception e)
    	{
    		
    	}
    	return false;
    	
    }
    
	public boolean changepwd() {
		try
    	{
    	pstmt = con.prepareStatement("update java set pwd=? where acc_no=?");
    	pstmt.setString(1, npwd);
    	pstmt.setString(2, acc_no);
        rs1 = pstmt.executeUpdate();
    	if(rs1>0)
    	{
    
    		return true;
    	}
    	}
    	catch(Exception e)
    	{
    		
    	}
		
		return false;
	}
	
	
	public boolean transfer()
	{
		try
    	{
			pstmt = con.prepareStatement("select * from java where acc_no=?");
			pstmt.setString(1, account);
	    	rs3 = pstmt.executeQuery();
	    	while(rs3.next())
	    	{
	    		newbalance = rs3.getInt(3);
	    	}
    	    
    	    pstmt = con.prepareStatement("update java set balance=? where acc_no=?");
    	    int trans1 = newbalance+amount;
    	    pstmt.setInt(1, trans1);
    	    pstmt.setString(2, account);
    	    rs4 = pstmt.executeUpdate();
        
    	if(rs4>0) 
    	{
    		pstmt = con.prepareStatement("update java set balance=? where acc_no=?");
    	    int trans = balance-amount;
    	    pstmt.setInt(1, trans);
    	    pstmt.setString(2, acc_no);
    	    rs2 = pstmt.executeUpdate();
    	    pstmt = con.prepareStatement("insert into statement values(?,?)");
    	    pstmt.setString(1, acc_no);
    	    pstmt.setInt(2, amount);
    	    pstmt.executeUpdate();
    	    return true;
    	}
    	}
    	catch(Exception e)
    	{
    		
    	}
		
		return false;
		
	}
	public ArrayList getstatement()
	{
		ArrayList al = new ArrayList();
		try
    	{
			
    	pstmt = con.prepareStatement("select * from statement where acc_no=?");
    	pstmt.setString(1, acc_no);
    	rs5 = pstmt.executeQuery();
    	while(rs5.next())
    	{
    		al.add(rs5.getInt(2));
    		
    	}
    	}
    	catch(Exception e)   	{
    		
    	}
    	return al;
    	
		
	}
		
	


}

