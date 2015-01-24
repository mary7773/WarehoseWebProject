<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/login.css" rel="stylesheet" type="text/css">
<title>Login form</title>

	
</head>
<body>
 	<div class="gradient">
        <h1><span class="create"><img src="images/login.png" width="130" height="100"/>Login form</span></h1>
    </div>
  <form class = "login" method="POST" action="Login" name="checkUser">      
       <label>USERNAME:</label>  <input
            type="text" name="userName"
            value="" /> <br /> 
       <label>PASSWORD:    </label>  <input
            type="password" name="password"
            value="" /> <br />       
             <input class="btn" type="submit" value="Login" />
    </form>
</body>
</html>