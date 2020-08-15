<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<%@ page import="java.util.ArrayList" %>
    <%@ page import="model.User" %>
    <%@ page import="model.Post" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
</head>
<body>

	<h1> Home Page</h1>
	<%
		User user = (User) session.getAttribute("user");
	%>
	
	<h3>${user.getFname()} ${user.getLname()}</h3>
	
	<%
		ArrayList<Post> allPostsList = (ArrayList<Post>) session.getAttribute("allPostsList");
	 if(allPostsList == null) {
         out.println(allPostsList.size() + " size");
     }
     else {
        
         for(Post p : allPostsList) {
            
             out.println(p.getPostContent() + " " + p.getLikes() + " ");
             //out.println("<a href='LikeController?id="+p.getPostID()+"'>Like</a>");
             //out.println("<a href='LikeController?id="+p.getPostId()+"'>Edit</a>");
         } 
     }
	
	 %>
	 
	 <a href="profile.jsp">Back</a>
</body>
</html>