<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<title>Main Window</title>
</head>
<body>

	<ul id="menu">
		<li><a href="#">Home</a></li>
		<li><a href="#">About</a>
			<ul class="hidden">
				<li><a href="#">Who We Are</a></li>
				<li><a href="#">What We Do</a></li>
			</ul></li>
		<li><a href="#">Operations</a>
			<ul class="hidden">
				<li><a href="${pageContext.request.contextPath}/Product">Add
						new products</a></li>

				<li><a href="category.jsp">Add new categories</a></li>

				<li><a href="brand.jsp">Add new brands</a></li>

				<li><a href="${pageContext.request.contextPath}/EditProduct">Edit
						products</a></li>

				<li><a href="${pageContext.request.contextPath}/EditCategory">Edit
						categories</a></li>

				<li><a href="${pageContext.request.contextPath}/EditBrand">Edit
						brands</a></li>

				<li><a href="${pageContext.request.contextPath}/LoadOrder">Order</a></li>
			</ul></li>
		<li><a href="#">News</a></li>
		<li><a href="#">Contact</a></li>
	</ul>

	<br />
	<br />
	<br />
	<br />

<form method="post" action="${pageContext.request.contextPath}/Product">
    <button type="submit"><img src="images/products.png" width="60" height="60" /></button>
     <a class="link" href="${pageContext.request.contextPath}/Product">Add a product</a>
</form>
<form method="post" action="category.jsp">
    <button type="submit"><img src="images/category.png" width="60" height="60" /></button>
   <a class="link" href="category.jsp">Add a category</a>
</form>
<form method="post" action="brand.jsp">
    <button type="submit"><img src="images/brand.png" width="60" height="60" /></button>
    <a class="link" href="brand.jsp">Add a brand</a>
</form>
<form method="post" action="${pageContext.request.contextPath}/LoadOrder">
    <button type="submit"><img src="images/cart.png" width="60" height="60" /></button>
    <a class="link" href="${pageContext.request.contextPath}/LoadOrder">Create an order</a>
</form>
<form method="post" action="${pageContext.request.contextPath}/LoadOrder">
    <button type="submit"><img src="images/payment.png" width="60" height="60" /></button>
    <a class="link" href="${pageContext.request.contextPath}/LoadOrder">Make a payment</a>
</form>
<form method="post" action="${pageContext.request.contextPath}/LoadOrder">
    <button type="submit"><img src="images/delivery.png" width="60" height="60" /></button>
    <a class="link" href="${pageContext.request.contextPath}/LoadOrder">Make a delivery</a>
</form>
		


</body>
</html>