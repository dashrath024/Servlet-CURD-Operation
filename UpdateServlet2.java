package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet2 extends HttpServlet {
	 public void service(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
	    	res.setContentType("text/html");
	    	PrintWriter out=res.getWriter();
	    	
	    	String id1=req.getParameter("id");
	    	int id=Integer.parseInt(id1);
	    	String last=req.getParameter("last");
	    	String first=req.getParameter("first");
	    	String add=req.getParameter("address");
	    	String city=req.getParameter("city");
	    	
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin");
			String sql="update Persons set last=?,first=?,address=?,city=?";
			PreparedStatement ps=con.prepareStatement(sql);	
			ps.setInt(0, id);
			ps.setString(1, last);
			ps.setString(2, first);
			ps.setString(3, add);
			ps.setString(4, city);
			int x=ps.executeUpdate();
			if(x>0){
				out.print("Added Successfully");
				}else{
				out.print("Try Again Something is wrong...!!");
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
  	
	 out.print("<a href='viewServlet'>View Records</a>");
	 }
	 }
