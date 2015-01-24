<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function setHiddenValue(obj)
{

	document.getElementById("hidden").value = obj;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Edit product</title>
</head>
<body>

	<div class="gradient">
        <h1>Edit products</h1><br />
    </div>
    <a href="main.jsp">Go back to Main Window</a>
	<br />
	<br />
<c:set var="counter" value="1"/>	

<form method="POST" action='GetProduct' name="getProduct">

<table border="1px">
    
    <tr>
    	<th>ID</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Category</th>
        <th>Brand</th>
        <th>Edit</th>
    </tr>

    <c:forEach items = "${list}"  var="product">
 
    <tr  id ="${counter}" onclick="setHiddenValue(${product.getId()});">
        <td >       
            <c:out  value="${product.getId()}" />
        </td>
        <td id="name">
            <c:out  value="${product.getName()}" />
        </td>
        <td id="qty">
            <c:out value="${product.getQuantity()}" />
        </td>
        <td id="price">
            <c:out value="${product.getPrice()}" />
        </td>
         <td id="cat">
            <c:out value="${product.getCategories().getName()}" />
        </td>
         <td id="brand">
            <c:out value="${product.getBrands().getName()}" />
        </td>
        <td>
           <input class="btn" type="submit" value="Edit"/> 
        </td> 
    </tr>
 <c:set var="counter"  value="${counter + 1}"/>
    </c:forEach>
</table>
<input  type="hidden" name="hidden" id="hidden" value="0" />

</form>
</body>
</html>