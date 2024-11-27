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


@WebServlet("/fetchdata")
public class fetchdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/one11" , "root" , "root");
			  PreparedStatement ps = conn.prepareStatement("select * from one");
			  ResultSet rs = ps.executeQuery();
			  
			  while(rs.next()) {
				   String name1 = rs.getString("name");
				   out.print(name1+" ");
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
	}

}
