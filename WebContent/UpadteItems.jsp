<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Product</title>
<link rel = "stylesheet" type = "text/css" href = "AddItems.css">
</head>
<body>
<%
	Connection DB = null;
	Statement st = null;
	ResultSet rs = null;
	DB = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shopping?useSSL=false", "root", "1551214374THEaa");
	PreparedStatement pstatement = null;
%>
<div class = "Container">
	<h1> Update Product </h1>
	<div class = "addForum">
		<form action = "http://localhost:8080/Items/Update" method = "post">
		<%
			String num = request.getParameter("update");
			st = DB.createStatement();
			String query = "select * from items where No ='"+num+"'";
			rs = st.executeQuery(query);
			while(rs.next()){
		%>
		<table id = "table" cellpadding = 5>
			<tr>
				<td> Name </td>
				<td><input name = "ProductName" type = "text" value ='<%=rs.getString(1)%>' required> </td>
			</tr>
			<tr>
				<td > Product ID </td>
				<td><input name = "ItemNo" value ='<%=rs.getString(2)%>' type = "text" required></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input name = "Price" value ='<%=rs.getInt(3)%>' type = "text" onkeypress ="InputNum(event)" required></td>
			</tr>
			<tr>
				<td>Qty</td>
				<td><input type = "text" name = "Qty" value ='<%=rs.getInt(4)%>' onkeypress ="InputNum(event)"></td>
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
				<td><textarea name = "Description" ><%=rs.getString(6)%></textarea></td>
			</tr>
			<tr>
				<td><input type = "submit" name = "ProductUpdate" value = "Update Product" id = "sub"> </td>
			</tr>
			<tr>
				<td><input type = "hidden" name = "No" value ='<%=rs.getInt(8)%>' ></td>
			</tr>
		</table>
		<%}%>
		</form>
	</div>
		<h2 id = "display" >${display}</h2>
		<script>
	function InputNum(input){
		var n = String.fromCharCode(input.which); 
		if(!(/[0-9]/.test(n))){
			input.preventDefault();
		}
	}
</script>	
</div>
</body>
</html>
