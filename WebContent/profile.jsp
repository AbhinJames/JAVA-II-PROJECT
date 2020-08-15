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
<title>Profile</title>
</head>
<body>
	<h1>Profile</h1>
	
	<%
		User user = (User) session.getAttribute("user");
	%>
	
	<h3> 
	
		${user.getFname()} ${user.getLname()}
	 </h3>
	 
	 <form action="CreatePost" method="POST">
	 <input type="text" name="postContent">
	 <input type="Submit" value="Create Post">
	</form>
	
	<%
		ArrayList<Post> userPostsList = (ArrayList<Post>) session.getAttribute("myPostsList");
	 if(userPostsList == null) {
         
     }
     else {
        
         for(Post p : userPostsList) {
            
             out.println(p.getPostContent() + " " + p.getLikes() + " ");
             //out.println("<a href='LikeController?id="+p.getPostID()+"'>Like</a>");
             //out.println("<a href='LikeController?id="+p.getPostId()+"'>Edit</a>");
         } 
     }
	
	 %>
	
</body>
</html>