<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="AddItems.css">
<meta charset="ISO-8859-1">
<title>Edit Mode</title>
</head>
<body>
<table border = 1 cellpadding = 5 >

	<tr bgcolor = #4CAF50>
		<td>Name</td>
		<td>Id</td>
		<td>Price</td>
		<td>Qty</td>
		<td>Category</td>
		<td colspan = "2"></td>
	</tr>

<%
	Connection DB = null;
	Statement st = null;
	ResultSet rs = null;
	DB = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shopping?useSSL=false", "root", "1551214374THEaa");
	String query = "Select * from items";
	
	st = DB.createStatement();
	
	rs = st.executeQuery(query);
	while(rs.next()){
%>	
	 
	<tr> 
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td >
				<a href='UpadteItems.jsp?update=<%=rs.getString(8)%>' id="UpdateButton">Update</a>
                <a href='http://localhost:8080/Items/Delete?delete=<%=rs.getString(8)%>' id="DeleteButton">Delete</a>
			</td>	

	</tr>
	
	
	<% 
	}
	%>
	
	
</table>
</body>
</html>