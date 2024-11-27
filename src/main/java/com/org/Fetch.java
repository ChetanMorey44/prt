package com.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		PrintWriter out = resp.getWriter();
    		Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chetan","root" , "root");
    		PreparedStatement ps = conn.prepareStatement("select * from one11");
    		ResultSet rs = ps.executeQuery();
    		out.println("<table class='table table-success table-striped table-hover'> <tr> <th>id </th> <th>FirstName</th> <th>Email</th> <th>Password</th>  </tr> ");
    		
    		while(rs.next()) {
    			int Id  = rs.getInt("id");
    			String Name  = rs.getString("name");
    			String Email = rs.getString("email");
    			String Password = rs.getString("password");
    			
    			out.println("<tr> <td>"+Id+"</td>  <td>"+Name+"</td>  <td>"+Email+"</td>  <td>"+Password+"</td> </tr>");
    		}
    		out.print("</table>");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
}
