<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function modifyTxt(obj)
{
	var category = obj.value;

	document.getElementById("message").value = category;
	
}

function timedRefresh() {
	location.reload();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit category</title>
</head>
<body>
<h1>Edit categories</h1>

<a href="main.jsp">Go back to Main Window</a>
	<br />
	<br />
	<form method="POST" action='EditCategory' name="editCategory">
				
		Categories : <select name = "category" onchange="modifyTxt(this);">
			<c:forEach items="${collection}" var="col">
				<option value="${col}">${col}</option>
			</c:forEach>
		</select>  <br /> <br />
		Edit the selected name : <textarea id="message" rows="1" cols="16" name ="categoryName"></textarea><br /> <br />
		<input type="submit" value="Edit"  onClick="timedRefresh()"/> 
		<input type="submit" value="Cancel" />
	</form>
</body>
</html>