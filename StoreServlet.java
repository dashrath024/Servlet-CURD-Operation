package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreServlet extends HttpServlet {
    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
    	res.setContentType("text/html");
    	PrintWriter out=res.getWriter();
    	
    	int x=0;
    	String id1=req.getParameter("id");
    	int id=Integer.parseInt(id1);
    	String last=req.getParameter("last");
    	String first=req.getParameter("first");
    	String add=req.getParameter("address");
    	String city=req.getParameter("city");
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin");
			PreparedStatement ps=con.prepareStatement("insert into Persons values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, last);
			ps.setString(3, first);
			ps.setString(4, add);
			ps.setString(5, city);
		    x=ps.executeUpdate();			

			
    	} catch (Exception e) {
			e.printStackTrace();
		}
    if(x>0){
		out.print("Added Successfully");
		req.getRequestDispatcher("index.jsp").include(req, res);
	}else{
		out.print("Try Again Something is wrong...!!");
	}
}
}
