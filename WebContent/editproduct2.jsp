<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Products</title>
</head>
<body>
	<h1>Edit products</h1>

	<a href="main.jsp">Go back to Main Window</a>
	<br />
	<br />
	<form method="POST" action='UpdateProduct' name="update">

		<c:forEach items="${collection}" var="col">
		<input type="hidden" name="hidden"  value="${col.getId()}" />
		Product Name : <textarea rows="1" cols="16" name="productName">${col.getName()}</textarea>
			<br />
			<br /> 
		Quantity : <textarea rows="1" cols="16" name="qty">${col.getQuantity()}</textarea>
			<br />
			<br /> 
		Price : <textarea rows="1" cols="16" name="price">${col.getPrice()}</textarea>
			<br />
			<br />
		Category : <textarea rows="1" cols="16" name="category">${col.getCategories().getName()}</textarea>
			<br />
			<br />
		Brand : <textarea rows="1" cols="16" name="brand">${col.getBrands().getName()}</textarea>
			<br />
			<br />
			<input type="submit" value="Edit" />
			<input type="submit" value="Cancel" />
		</c:forEach>

	</form>


</body>
</html>