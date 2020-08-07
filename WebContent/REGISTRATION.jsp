<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTARTION PAGE</title>
</head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;
	background-color: #CCFF00;
	padding: 70px 30px;
	top-left:30px;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 20%;
  align: left;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  top-left:70px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 10%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<h2>Registration Form</h2>

<form action="        " method="post">
  <div class="imgcontainer">
    <img src="C:\Users\nperla\Desktop\java script\JAVA-EE-PROJECT\WebContent\img_avatar2.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="fname"><b>First Name</b></label>
    <input type="text" placeholder="Enter Your First name" name="fname" required>
    
    <label for="lname"><b>Last Name </b></label>
    <input type="text" placeholder="Enter Your Last name" name="lname" required>
    
    <label for="email "><b>Email</b></label>
    <input type="text" placeholder="Enter Your Email" name="email" required>
    
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
        
    <button type="submit">Sign in</button>
    <label>
      <input type="checkbox"  name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
  
  </div>
</form>
</html>