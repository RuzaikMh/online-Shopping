<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Products List </h1>
<form action = "ViewItemsController" method = "post">
		<input type = "submit" name = "ProductSubmit" value = "Add Product" id = "sub">

</form>
<form action = "Edit" method = "post">
<input type = "submit" name = "ProductEdit" value = "Edit Product" id = "edit"> 
</form>
</body>
</html>