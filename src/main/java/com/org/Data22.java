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
import javax.servlet.http.HttpSession;


@WebServlet("/Data22")
public class Data22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String Name = req.getParameter("one");
	 String Email = req.getParameter("two");
	 String Password = req.getParameter("three");
	 
	 PrintWriter out = resp.getWriter();
	 
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chetan","root","root");
		 Statement st = conn.createStatement();
		 st.executeUpdate("insert into one11 ( name , email , password ) values ('"+Name+"' , '"+Email+"' , '"+Password+"')");
		 out.print("Done");
		 
		
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
}

}
