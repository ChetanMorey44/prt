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


@WebServlet("/Logins")
public class Logins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 String Email = req.getParameter("email");
    	 String Password = req.getParameter("pass");
    	 
    	 resp.setContentType("text/html");
    	 PrintWriter out = resp.getWriter();
    	 
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chetan","root","root");
    		 PreparedStatement ps = conn.prepareStatement("select * from one11 where email=? and Password=?");
    		 ps.setString(1, Email);
    		 ps.setString(2, Password);
    		 
    		 ResultSet rs = ps.executeQuery();
    		 
    		 if(rs.next()) {
    			 out.print("<h4 style='color:green'>Successfully done </h4>");
    		 }else {
    			 out.print("<h4 style='color:red'>Id And Password Didnt match </h4>");
    		 }
    	 }catch(Exception e) {
    		e.printStackTrace();
    		 out.print("<h4 style='color:red'>Id And Password Didnt match </h4>");
    	 }
    }

}
