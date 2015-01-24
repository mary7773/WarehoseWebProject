<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/category.css" rel="stylesheet" type="text/css">
<title>Add categories</title>
</head>
<body>
<div class="gradient">
        <h1><span class="create"><img src="images/category.png" width="130" height="100"/>Add category</span></h1>
  </div>

	<a class="main" href="main.jsp">Go back to Main Window</a>
	<br />
	<br />

	<form class = "login" method="POST" action='Category' name="saveCategory">
		Category Name : <input type="text" name="categoryName" /> <br /> <br />
		<input class="button" type="submit" value="Save" /> 
		<input class="button" type="submit" value="Cancel" />
	</form>
</body>
</html>