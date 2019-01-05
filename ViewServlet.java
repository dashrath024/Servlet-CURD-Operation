package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	 public void service(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
	    	res.setContentType("text/html");
	    	PrintWriter out=res.getWriter();
	    	
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin");
				String sql="select * from Persons";
				PreparedStatement ps=con.prepareStatement(sql);			
                ResultSet rs=ps.executeQuery();
                while(rs.next()){

                    out.print("<table border='1' width='100%'>");
                	out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>");
                    out.print("</table>");
                }
	    	} catch (Exception e) {
				e.printStackTrace();
			}
}
}