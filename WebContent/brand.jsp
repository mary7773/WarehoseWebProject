<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Add brands</title>
</head>
<body>
	<h1>Add new brands</h1>
	<a href="main.jsp">Go back to Main Window</a>
	<br />
	<br />

	<form method="POST" action='Brand' name="saveBrand">
		Brand Name : <input type="text" name="brandName" /> <br />
		<br /> <input type="submit" value="Save" /> 
		<input type="submit" value="Cancel" />
	</form>

</body>
</html>