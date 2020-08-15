<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.*" %>  
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
	 
	 <form action="CreatePost" method="get">
	 <input type="text" name="postContent">
	 <input type="Submit" value="Create Post">
	</form>
	
</body>
</html>