<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
</head>
<body>
<h1>Order</h1>

<a href="main.jsp">Go back to Main Window</a>
	<br />
	<br />
	<form method="POST" action='AddOrder' name="addOrder">
	
		Date: <c:out value="${date}" ></c:out><br /> <br />	
		List of Customers : <select name = "customer">
			<c:forEach items="${collection}" var="col">
				<option value="${col}">${col}</option>
			</c:forEach>
		</select>  <br /> <br />
		List of Products : <select name = "product" >
			<c:forEach items="${collection1}" var="col1">
				<option value="${col1}">${col1}</option>
			</c:forEach>
		</select>  <br /> <br />
		Quantity : <textarea id="message" rows="1" cols="16" name ="qty"></textarea><br /> <br />
		
		<input type="submit" value="Add"  /> 
		<input type="submit" value="Cancel" />
	</form>
<br /> <br />		
	<table border="1px">
    
    <tr>
    	<th>ID</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Available Quantity</th>
        <th>Price</th>
        <th>Total</th>
    </tr>

    <c:forEach items = "${list}"  var="product">
 
    <tr >
        <td >       
            <c:out  value="${product.getProducts().getId()}" />
        </td>
        <td id="name">
            <c:out  value="${product.getProducts().getName()}" />
        </td>
        <td id="qty">
            <c:out value="${product.getQuantity()}" />
        </td>
         <td id="qty1">
            <c:out value="${product.getProducts().getQuantity()}" />
        </td>
        <td id="price">
            <c:out value="${product.getProducts().getPrice()}" />
        </td>
         <td id="total">
            <c:out value="${product.getTotal()}" />
        </td>     
    </tr>   
    </c:forEach>
</table>
<br /> <br />	
Total : <textarea rows="1" cols="16" name ="total1">${total1}</textarea><br /> <br />
<form method="POST" action='SaveOrder' name="saveOrder">
	
		<input type="submit" value="Save"  /> 
		<input type="submit" value="Cancel" />
</form>

</body>
</html>