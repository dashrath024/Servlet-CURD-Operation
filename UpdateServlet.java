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

public class UpdateServlet extends HttpServlet{
	 public void service(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
	    	res.setContentType("text/html");
	    	PrintWriter out=res.getWriter();
	    	String id2=req.getParameter("id");
	    	int id=Integer.parseInt(id2);
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin");
				String sql="select * from Persons where id=id";
				PreparedStatement ps=con.prepareStatement(sql);	
				ResultSet rs=ps.executeQuery();
               while(rs.next()){
				out.print("<form action='UpdateServlet2' method='post'>");  
		        out.print("<table>");  
		        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+rs.getInt(1)+"'/></td></tr>");  
		        out.print("<tr><td>Name:</td><td><input type='text' name='last' value='"+rs.getString(2)+"'/></td></tr>");  
		        out.print("<tr><td>Name:</td><td><input type='text' name='first' value='"+rs.getString(3)+"'/></td></tr>");  
		        out.print("<tr><td>Name:</td><td><input type='text' name='address' value='"+rs.getString(4)+"'/></td></tr>");  
		        out.print("<tr><td>Name:</td><td><input type='text' name='city' value='"+rs.getString(5)+"'/></td></tr>");  
		        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");  
               }
	    	} catch (Exception e) {
				e.printStackTrace();
			}
}

}
