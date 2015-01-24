<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add products</title>

</head>
<body>
	<h1>Add new products</h1>
	<a href="main.jsp">Go back to Main Window</a>
	<br />
	<br />
	<form method="POST" action="Product" name="saveProduct">
		Product Name : <input type="text" name="productName" /> <br />
		Quantity : <input type="text" name="quantity" /> <br /> 
		Price : <input
			type="text" name="price" /> <br /> 
		Categories : <select name = "category">
			<c:forEach items="${collection1}" var="col1">
				 <div id="item1"><option value="${col1}">${col1}</option></div>
			</c:forEach>
		</select> <br /> 
		Brands : <select name = "brand">
			<c:forEach items="${collection}" var="col">
				 <div id="item"><option value="${col}">${col}</option></div>
			</c:forEach>
		</select> <br /> <br />
		<input type="submit" value="Save" /> 
		<input type="submit" value="Cancel" />
	</form>

</body>
</html>