<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Product</title>
<link rel = "stylesheet" type = "text/css" href = "AddItems.css">
</head>
<body>
<div class = "Container">
	<h1> Add New Product </h1>
	<div class = "addForum">
		<form action = "http://localhost:8080/Items/AddItems" method = "post">
		<table id = "table" cellpadding = 5>
			<tr>
				<td> Name </td>
				<td><input name = "ProductName" type = "text" placeholder = "Enter Product Name" required> </td>
			</tr>
			<tr>
				<td > Product ID </td>
				<td><input name = "ItemNo" placeholder = "Enter Product ID" type = "text" required></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input name = "Price" placeholder = "Enter Price of the Product" type = "text" onkeypress ="InputNum(event)" required></td>
			</tr>
			<tr>
				<td>Qty</td>
				<td><input type = "text" name = "Qty" placeholder = "Enter quantity" onkeypress ="InputNum(event)"></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><select name = "Category" >
					<option value="" disabled selected>Select Category </option>
					<option value = "CellPhones&Accessories"> Cell Phones &amp; Accessories</option>
					<option value = "Clothing">Clothing</option>
					<option value = "Consumer Electronics">Consumer Electronics</option>
					<option value = "Books">Books </option>
					</select>
				</td>
			</tr> 
			<tr>
				<td> Picture </td>
				<td><input type = "file" name = "Pimage" accept = "image/*"> </td>
			</tr>
			<tr>
				<td> Description </td>
				<td><textarea name = "Description"></textarea></td>
			</tr>
			<tr>
				<td><input type = "submit" name = "ProductSubmit" value = "Add Product" id = "sub"> </td>
			</tr>
		</table>
		</form>
	</div>
	<h2 id = "display" >${display}</h2>
</div>
<script>
	function InputNum(input){
		var n = String.fromCharCode(input.which); 
		if(!(/[0-9]/.test(n))){
			input.preventDefault();
		}
	}
</script>	
</body>
</html>