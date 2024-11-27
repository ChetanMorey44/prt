<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

          <%
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chetan" , "root" , "root");
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from one11");
             out.println("<table class='table table-bordered'><tr><th>Name</th> <th>Email</th> <th>Password</th></tr>");
             
             while(rs.next()){
            	 String Name = rs.getString("name");
            	 String Email = rs.getString("email");
            	 String Password = rs.getString("password");
            	 out.println("<tr><td>"+Name+"</td><td>"+Email+"</td><td>"+Password+"</td></tr>");
             }
             out.print("</table>");
          %>
   
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
   
</body>
</html>