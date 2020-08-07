<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
  input[type=text],[type=email], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

/* Style the submit button */
input[type=submit],[type=reset] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}


input[type=submit]:hover {
  background-color: #45a049;
}
</style>
<meta charset="ISO-8859-1">
<title>Create User Page</title>
</head>


<body>

<div align="center">
<table>
<tbody><tr>
<td align="center">

<form action="CreateUser" method="Post">
<fieldset>
<fieldset>Registration Form</fieldset>
<br>
<label> Enter First Name: </label>
<input type="text" name="fname">
<br>
<label> Enter Last Name: </label>
<input type="text" name="lname">
<br>
<label> Enter Your Email : </label>
<input type="email" name="email">
<br>
<label> Enter Password: </label>
<input type="text" name="password"> 
<br>
<input type="submit" value="Submit">
<button type="reset">Clear</button>
</fieldset>
</form>
</td>
</tr>
</tbody></table>

<table>
<tbody>
<tr>
<td align="center">

<form action = "Login" method="POST">
<fieldset>
<fieldset>Login</fieldset>
<br>
<label> Enter Your Email : </label>
<input type="email" name="email">
<br>
<label> Enter Password: </label>
<input type="text" name="password"> 
<br>
<input type="submit" value="Login">
<button type="reset">Clear</button>
</fieldset>
</form>
</td>
</tr>
</tbody></table>
</div>

</body>
</html>