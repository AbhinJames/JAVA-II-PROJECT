<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="CreateUser" method="POST">
		<input type="text" name="fname" /><br>
		<input type="text" name="lname" /><br>
		<input type="email" name="email" /><br>
		<input type="password" name="pass" /><br>
		<button type="submit">Login</button>
		<button type="reset">Clear</button>
	</form>
	
	
	<form action="Login" method="POST">
		<input type="email" name="email" /><br>
		<input type="password" name="pass" /><br>
		<button type="submit">Login</button>
		<button type="reset">Clear</button>
	</form>


</body>
</html>