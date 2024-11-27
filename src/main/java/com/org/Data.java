package com.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String name = req.getParameter("name");
    	String email = req.getParameter("email");
    	String pass = req.getParameter("pass");
    	
    	PrintWriter out = resp.getWriter();
//    	out.print(p		ass+" "+email+" "+name);
    	
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/one11","root","root");
			Statement st = conn.createStatement();
			st.executeUpdate("insert into one (name , email , password) values ('"+name+"', '"+email+"', '"+pass+"')");
			out.print(pass+" "+email+" "+name);
		} catch (Exception  e) {
			e.printStackTrace();
		}
    	
    }

}
