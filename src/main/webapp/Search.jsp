<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="#" method="get">
       <input type="search" name="searchs"/>
   </form>
   <%
     String Search = request.getParameter("searchs");
     response.setContentType("text/html");
     
     String Name = (String) session.getAttribute("name");
     String Email = (String) session.getAttribute("email");
     String Password = (String) session.getAttribute("password");
  
     
     Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chetan","root","root");
	 PreparedStatement ps = conn.prepareStatement("select * from one11 where name=? and password='pass12345' ");
	 ps.setString(1, Search);
	 
	 ResultSet rs = ps.executeQuery();
	
	 while(rs.next()){
		 
   %>
      
      <p>Name: <%= rs.getString("name") %></p>
      <p>Email: <%= rs.getString("email") %></p>
      <p>Password: <%= rs.getString("password") %></p>
      
   <%
	 }
   %>
</body>
</html>